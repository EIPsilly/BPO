package BPO.login.mybatis.po;

import com.alibaba.fastjson.annotation.JSONField;

public class User {

    @JSONField(name = "User_ID")
    private String User_ID;
    @JSONField(name = "User_Name")
    private String User_Name;
    @JSONField(name = "Password")
    private String Password;

    public User() {
    }

    public User(String user_ID, String user_Name, String password) {
        User_ID = user_ID;
        User_Name = user_Name;
        Password = password;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
