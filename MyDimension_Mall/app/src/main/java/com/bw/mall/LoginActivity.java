package com.bw.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.bean.LoginRegisterBean;
import com.bw.mall.contractClass.LoginContractClass;
import com.bw.mall.mvp.login.LoginPresenterImpl;
import com.bw.mall.utils.SpUtil;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContractClass.LoginViewLayer {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.ib_eye)
    ImageButton ibEye;
    @BindView(R.id.check_box)
    CheckBox checkBox;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private Unbinder butterknife;
    private int LOGIN = 200;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //绑定 butterknife
        butterknife = ButterKnife.bind(this);

        //取出
        SpUtil instance = SpUtil.getInstance();
        String phone = instance.getCachData(SpUtil.SP_PHONE);
        String pwd = instance.getCachData(SpUtil.SP_PWD);
        boolean empty1 = TextUtils.isEmpty(phone);
        boolean empty2 = TextUtils.isEmpty(pwd);
        if(!(empty1||empty2)){
            checkBox.setChecked(true);
            etPhone.setText(phone);
            etPwd.setText(pwd);
        }

    }
    //点击事件
    @OnClick({R.id.ib_eye,R.id.check_box, R.id.tv_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_eye:
                //文本隐藏
                etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            case R.id.check_box:
                //单选框
                break;
            case R.id.tv_register:
                //进入注册界面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,LOGIN);
                break;
            case R.id.btn_login:
                //登入
                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone",phone);
                hashMap.put("pwd",pwd);
                String path = "http://mobile.bwstudent.com/small/user/v1/login";
                presenter.loginUser(path,hashMap);
                break;
        }
        //小眼睛的长按事件
        ibEye.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //文本显示
                etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                //返回 false 执行点击事件
                return false;
            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 200){
            if (data != null) {
                String phone = data.getStringExtra("phone");
                String pwd = data.getStringExtra("pwd");
                etPhone.setText(phone);
                etPwd.setText(pwd);
            }
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑  防止内存泄露
        if (butterknife != null) {
            butterknife.unbind();
        }
    }

    @Override
    public void loginViewSuccess(String json) {
        Gson gson = new Gson();
        LoginRegisterBean bean = gson.fromJson(json, LoginRegisterBean.class);
        bean.getResult();//登录信息

        String message = bean.getMessage();
        if (message.contains("登陆失败,手机号或密码错误")) {
            etPhone.setText("");
            etPhone.setHint("登陆失败,手机号或密码错误");
        } else if(message.contains("登录成功")){
            Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
            //判断 记住密码是否选中
            boolean checked = checkBox.isChecked();
            if (checked) {
                //存储到sp
                SpUtil instance = SpUtil.getInstance();
                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                instance.setCacheData(SpUtil.SP_PHONE,phone);
                instance.setCacheData(SpUtil.SP_PWD,pwd);
            }
            Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
            startActivity(intent);
            //销毁当前页面
            finish();
        }
    }

    @Override
    public void loginViewFail(String error) {
        Toast.makeText(this, "错误 错误", Toast.LENGTH_SHORT).show();
    }
}
