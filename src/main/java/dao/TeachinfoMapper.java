package dao;

import domain.Teachinfo;
import java.util.List;

public interface TeachinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teachinfo record);

    Teachinfo selectByPrimaryKey(Integer id);

    List<Teachinfo> selectAll();

    int updateByPrimaryKey(Teachinfo record);
}