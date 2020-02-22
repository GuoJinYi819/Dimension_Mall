package com.bw.mall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity {

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

    }
    //点击事件
    @OnClick({R.id.ib_eye, R.id.check_box, R.id.tv_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_eye:
                //查看密码
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
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑  防止内存泄露
        if (butterknife != null) {
            butterknife.unbind();
        }
    }
}
