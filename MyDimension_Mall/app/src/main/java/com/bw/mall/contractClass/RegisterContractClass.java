package com.bw.mall.contractClass;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 21:36
 * @Description: 用途：完成特定功能
 */
public class RegisterContractClass {
    //view 层
    public interface RegisterViewLayer{
        //成功
        void registerViewSuccess(String json);
        //失败
        void registerViewFail(String error);
    }
    //module层
    public interface RegisterModuleLayer{
        void registerUser(String path, Map<String,String> param,RegisterModuleCallBack registerModuleCallBack);
        interface RegisterModuleCallBack{
            void registerModuleSuccess(String json);
            void registerModuleFail(String error);
        }
    }
    //presenter层
   public interface RegisterPresenterLayer{
        void registerUser(String path,Map<String,String> param);
    }
}
