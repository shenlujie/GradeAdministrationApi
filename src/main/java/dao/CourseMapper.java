package dao;

import domain.Course;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cno);

    int insert(Course record);

    Course selectByPrimaryKey(Integer cno);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);
}