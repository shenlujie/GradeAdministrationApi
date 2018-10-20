package dao;

import domain.GradeInfoDetails;

public interface GradeInfoDetailsMapper {
    GradeInfoDetails selectGradeInfoDetails(String sno,Integer cno);
}
