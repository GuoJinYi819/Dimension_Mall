package com.bw.mall.contractClass;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 21:36
 * @Description: 用途：完成特定功能
 */
public class LoginContractClass {
    //view 层
    interface LoginViewLayer{
        //成功
        void loginViewSuccess(String json);
        //失败
        void loginViewFail(String error);
    }
    //module层
    interface LoginModuleLayer{
        void loginUser(String path, Map<String, String> param, LoginModuleCallBack loginModuleCallBack);
        interface LoginModuleCallBack{
            void loginModuleSuccess(String json);
            void loginModuleFail(String error);
        }
    }
    //presenter层
    interface LoginPresenterLayer{
        void loginUser(String path, Map<String, String> param);
    }
}