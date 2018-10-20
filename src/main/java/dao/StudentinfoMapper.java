package dao;

import domain.Studentinfo;
import java.util.List;

public interface StudentinfoMapper {
    int deleteByPrimaryKey(String sno);

    int insert(Studentinfo record);

    Studentinfo selectByPrimaryKey(String sno);

    List<Studentinfo> selectAll();

    int updateByPrimaryKey(Studentinfo record);
}