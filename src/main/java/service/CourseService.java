package service;

import dao.CourseMapper;
import domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CourseService
 *
 * @author chain-generator 2018-10-12
 */
@Service
public class CourseService {
    /*
     * 自定义扩展
     */
    @Autowired
    CourseMapper courseMapper;

    public List<Course> selectCourse(){
        return courseMapper.selectAll();
    }

}
