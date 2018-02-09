package kr.or.dgit.mybatis_sample.dao;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;

public class StudentDaoImpl implements StudentDao {
	private SqlSession sqlSession;
	
	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);
	
	public StudentDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		log.debug("selectStudentByNo()");
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		return studentDao.selectStudentByNo(student);
	}

}
