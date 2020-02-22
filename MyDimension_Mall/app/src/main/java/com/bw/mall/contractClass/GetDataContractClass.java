package com.bw.mall.contractClass;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/19 21:36
 * @Description: 用途：完成特定功能
 */
public class GetDataContractClass {
    //view 层
    public interface GetDataViewLayer{
        //成功
        void getDataViewSuccess(String json);
        //失败
        void getDataViewFail(String error);
    }
    //module层
    public interface GetDataModuleLayer{
        void getDataUser(String path, GetDataModuleCallBack getDataModuleCallBack);
        interface GetDataModuleCallBack{
            void getDataModuleSuccess(String json);
            void getDataModuleFail(String error);
        }
    }
    //presenter层
    public interface GetDataPresenterLayer{
        void getDataUser(String path);
    }
}
