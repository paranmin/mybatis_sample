package kr.or.dgit.mybatis_sample.dao;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	Student selectStudentByNo(Student student);
}
