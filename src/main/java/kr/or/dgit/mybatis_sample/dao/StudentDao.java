package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
	
	List<Student> selectStudentByAllForResultMapWithAPI();
	List<Map<String, Object>> selectStudentByAllForMapWithAPI();
	
	// select Extends
	Student selectStudentByNoForResultMapExtendsWithAPI(Student student);
	
	// select Extends Association
	Student selectStudentByNoForAssociationWithAPI(Student student);
	
	// insert
	int insertStudentWithAPI(Student student);
	int insertEnumStudentWithAPI(Student student);
	
	// update
	int updateStudentWithAPI(Student student);
	
	// delete
	int deleteStudentWithAPI(int no);
	
	// select 여러 입력 파라미터
	Student selectAllStudentByStudentWithAPI(Student student);
	Student selectAllStudentByMapWithAPI(Map<String, String> map);
}
