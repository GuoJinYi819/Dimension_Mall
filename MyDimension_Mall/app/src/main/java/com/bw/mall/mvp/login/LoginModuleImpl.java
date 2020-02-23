package com.bw.mall.mvp.login;

import com.bw.mall.contractclass.LoginContractClass;
import com.bw.mall.utils.NetUtil;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 13:04
 * @Description: 用途：完成特定功能
 */
public class LoginModuleImpl implements LoginContractClass.LoginModuleLayer {
    @Override
    public void loginUser(String path, Map<String, String> param, LoginModuleCallBack loginModuleCallBack) {
        NetUtil instance = NetUtil.getInstance();
        instance.doPostUser(path, param, new NetUtil.NetCallBack() {
            @Override
            public void netSuccess(String json) {
                loginModuleCallBack.loginModuleSuccess(json);
            }

            @Override
            public void netFiled(String error) {
                loginModuleCallBack.loginModuleFail(error);
            }
        });
    }
}
