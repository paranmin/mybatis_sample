package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

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
	
	public int insertEnumStudent(Student student) {
		log.debug("insertEnumStudent()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertEnumStudent(student);
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
	
	public List<Map<String,Object>> selectStudentByAllForHashMap() {
		log.debug("selectStudentByAllForHashMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForHashMap();
		}
	}
	
	public Student selectStudentByNoForResultMapExtends(Student student) {
		log.debug("selectStudentByNoForResultMapExtends()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoForResultMapExtends(student);
		}
	}
	
	public Student selectStudentByNoAccociation(Student student) {
		log.debug("selectStudentByNoAccociation()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAccociation(student);
		}
	}
	
	public Student findAllStudentByParam(String name, String email) {
		log.debug("selectAllStudentByParam()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByParam(name, email);
		}
	}
	public Student findAllStudentByStudent(Student student) {
		log.debug("selectAllStudentByStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByStudent(student);
		}
	}
	public Student findAllStudentByMap(Map<String, String> map) {
		log.debug("selectAllStudentByMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByMap(map);
		}
	}
}
