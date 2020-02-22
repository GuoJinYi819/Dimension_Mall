package com.bw.mall;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.mall.base.BaseActivity;
import com.bw.mall.base.BasePresenter;
import com.bw.mall.utils.NetUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.ib_eye1)
    ImageButton ibEye1;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }
    //点击事件
    @OnClick({R.id.tv_code, R.id.ib_eye1, R.id.tv_register, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                //获取验证码
                break;
            case R.id.ib_eye1:
                //眼睛
                break;
            case R.id.tv_register:
                //立即登入  返回登入界面
                finish();
                break;
            case R.id.btn_register:
                //注册
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone","15636463798");
                hashMap.put("pwd","g123456");
                NetUtil instance = NetUtil.getInstance();
                instance.doPostUser("http://mobile.bwstudent.com/small/user/v1/register", hashMap, new NetUtil.NetCallBack() {
                    @Override
                    public void netSuccess(String json) {
                        Log.i("aa", "netSuccess: "+json);
                    }

                    @Override
                    public void netFiled(String error) {
                        Toast.makeText(RegisterActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                });
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

}

