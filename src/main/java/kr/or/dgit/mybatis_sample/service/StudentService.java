package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	
	public Student findStudent(Student student) {
		log.debug("selectStudentByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}
	
	public List<Student> findStudentByAll() {
		log.debug("selectStudentByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}
	
	public int insertStudent(Student student) {
		log.debug("insertStudent()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertStudent(student);
			sqlSession.commit();
		}
		return res;
	}
	
	public int updateStudent(Student student) {
		log.debug("updateStudent()");
		int res = -1;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.updateStudent(student);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteStudent(int no) {
		log.debug("updateStudent()");
		int res = -1;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.deleteStudent(no);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Student> selectStudentByAllForResultMap() {
		log.debug("selectStudentByAllForResultMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForResultMap();
		}
	}
}
