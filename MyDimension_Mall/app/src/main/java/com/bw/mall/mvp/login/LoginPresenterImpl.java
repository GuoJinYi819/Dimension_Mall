package com.bw.mall.mvp.login;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.contractClass.LoginContractClass;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 13:05
 * @Description: 用途：完成特定功能
 */
public class LoginPresenterImpl extends BasePresenter<LoginContractClass.LoginViewLayer> implements LoginContractClass.LoginPresenterLayer {
    private LoginModuleImpl module;
    @Override
    protected void initModule() {
        module = new LoginModuleImpl();
    }

    @Override
    public void loginUser(String path, Map<String, String> param) {
        module.loginUser(path, param, new LoginContractClass.LoginModuleLayer.LoginModuleCallBack() {
            @Override
            public void loginModuleSuccess(String json) {
                baseView.loginViewSuccess(json);
            }

            @Override
            public void loginModuleFail(String error) {
                baseView.loginViewFail(error);
            }
        });
    }
}
