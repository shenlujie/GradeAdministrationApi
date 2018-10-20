package service;

import dao.GradeInfoDetailsMapper;
import domain.GradeInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeInfoDetailsService {

    @Autowired
    GradeInfoDetailsMapper gradeInfoDetailsMapper;

    public GradeInfoDetails selectGradeInfoDetails(String sno,Integer cno){
        return gradeInfoDetailsMapper.selectGradeInfoDetails(sno,cno);
    }
}
