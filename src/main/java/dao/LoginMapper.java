package dao;

import domain.Login;
import java.util.List;

public interface LoginMapper {
    int deleteByPrimaryKey(String account);

    int insert(Login record);

    Login selectByPrimaryKey(String account);

    List<Login> selectAll();

    int updateByPrimaryKey(Login record);
}