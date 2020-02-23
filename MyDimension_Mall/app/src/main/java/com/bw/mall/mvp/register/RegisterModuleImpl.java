package com.bw.mall.mvp.register;

import com.bw.mall.contractclass.RegisterContractClass;
import com.bw.mall.utils.NetUtil;

import java.util.Map;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 10:50
 * @Description: 用途：完成特定功能
 */
public class RegisterModuleImpl implements RegisterContractClass.RegisterModuleLayer {
    @Override
    public void registerUser(String path, Map<String, String> param, RegisterModuleCallBack registerModuleCallBack) {
        NetUtil instance = NetUtil.getInstance();
        instance.doPostUser(path, param, new NetUtil.NetCallBack() {
            @Override
            public void netSuccess(String json) {
                registerModuleCallBack.registerModuleSuccess(json);
            }

            @Override
            public void netFiled(String error) {
                registerModuleCallBack.registerModuleFail(error);
            }
        });
    }
}
