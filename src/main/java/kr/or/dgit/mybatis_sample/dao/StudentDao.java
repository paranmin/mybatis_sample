package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	// select resultMap
	List<Student> selectStudentByAllForResultMap();
	List<Map<String,Object>> selectStudentByAllForHashMap();
	
	// select extends
	Student selectStudentByNoForResultMapExtends(Student student);
	
	Student selectStudentByNoAccociation(Student student);
	
	// insert
	int insertStudent(Student student);
	
	// update
	int updateStudent(Student student);
	
	// delete
	int deleteStudent(int id);
}
