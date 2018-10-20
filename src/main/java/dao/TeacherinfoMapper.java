package dao;

import domain.Teacherinfo;
import java.util.List;

public interface TeacherinfoMapper {
    int deleteByPrimaryKey(String tno);

    int insert(Teacherinfo record);

    Teacherinfo selectByPrimaryKey(String tno);

    List<Teacherinfo> selectAll();

    int updateByPrimaryKey(Teacherinfo record);
}