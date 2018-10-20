package service;

import dao.ScMapper;
import domain.Sc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ScService
 *
 * @author chain-generator 2018-10-12
 */
@Service
public class ScService {
    /*
     * 自定义扩展
     */

    @Autowired
    ScMapper scMapper;

    public List<Sc> selectGrade(String sno){
        return scMapper.selectGrade(sno);
    }

}
