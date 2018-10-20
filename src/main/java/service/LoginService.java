package service;

import dao.LoginMapper;
import domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginService
 *
 * @author chain-generator 2018-10-12
 */
@Service
public class LoginService {
    /*
     * 自定义扩展
     */
    @Autowired
    LoginMapper loginMapper;


    public Login selectByPrimaryKey(String account){
        return loginMapper.selectByPrimaryKey(account);
    }

    public int insert(Login record){
        return loginMapper.insert(record);
    }

    public int updateLoginInfo(Login login){
        return loginMapper.updateByPrimaryKey(login);
    }

}
