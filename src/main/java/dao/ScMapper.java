package dao;

import domain.Sc;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScMapper {
    int deleteByPrimaryKey(@Param("tno") String tno, @Param("cno") Integer cno, @Param("sno") String sno);

    int insert(Sc record);

    Sc selectByPrimaryKey(@Param("tno") String tno, @Param("cno") Integer cno, @Param("sno") String sno);

    List<Sc> selectAll();

    int updateByPrimaryKey(Sc record);

    //根据学号查询成绩信息
    List<Sc> selectGrade(String sno);
}