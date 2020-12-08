package BPO.login.dao;

import BPO.login.mybatis.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User SelectUserByUser_Name(String User_Name);
    int InsertIntoUser(User user);
}
