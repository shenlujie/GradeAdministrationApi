package service;

import dao.StudentinfoMapper;
import domain.Studentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StudentinfoService
 *
 * @author chain-generator 2018-10-12
 */
@Service
public class StudentinfoService {
    /*
     * 自定义扩展
     */

    @Autowired
    StudentinfoMapper studentinfoMapper;

    public int insert(Studentinfo record){
        return studentinfoMapper.insert(record);
    }

    public Studentinfo selectStudentInfo(String sno){
        return studentinfoMapper.selectByPrimaryKey(sno);
    }

    public int updateStudentInfo(Studentinfo studentinfo){
        return studentinfoMapper.updateByPrimaryKey(studentinfo);
    }

}
