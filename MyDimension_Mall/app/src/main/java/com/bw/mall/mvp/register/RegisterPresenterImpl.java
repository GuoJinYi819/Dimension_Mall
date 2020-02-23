package com.bw.mall.mvp.register;

import com.bw.mall.base.BasePresenter;
import com.bw.mall.contractclass.RegisterContractClass;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 10:52
 * @Description: 用途：完成特定功能
 */
public class RegisterPresenterImpl extends BasePresenter<RegisterContractClass.RegisterViewLayer> implements RegisterContractClass.RegisterPresenterLayer {
    private RegisterModuleImpl module;
    @Override
    protected void initModule() {
        module = new RegisterModuleImpl();
    }

    @Override
    public void registerUser(String path, Map<String, String> param) {
        module.registerUser(path, param, new RegisterContractClass.RegisterModuleLayer.RegisterModuleCallBack() {
            @Override
            public void registerModuleSuccess(String json) {
                baseView.registerViewSuccess(json);
            }

            @Override
            public void registerModuleFail(String error) {
                baseView.registerViewFail(error);
            }
        });
    }
}
