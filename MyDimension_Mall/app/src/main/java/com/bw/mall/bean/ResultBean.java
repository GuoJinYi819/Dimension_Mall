package com.bw.mall.bean;

/**
 * ClassName: MyDimension_Mall
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/23 13:12
 * @Description: 用途：完成特定功能
 */
public class ResultBean {
    private String headPic;//头像
    private String nickName;//昵称
    private String phone;//手机号
    private String sessionId;//会议id
    private int sex;//性别
    private int userId;//用户id

    public String getHeadPic() {
        return headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getSex() {
        return sex;
    }

    public int getUserId() {
        return userId;
    }
}
