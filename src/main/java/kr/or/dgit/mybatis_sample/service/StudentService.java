package kr.or.dgit.mybatis_sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
	public Student findStudentWithAPI(Student student) {
		log.debug("findStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoWithAPI", student);
		}
	}
	
	public List<Student> findStudentByAllWithAPI() {
		log.debug("findStudentByAllWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPI");
		}
	}
	
	public int insertStudentWithAPI(Student student) {
		log.debug("insertStudentWithAPI()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertStudentWithAPI", student);
			sqlSession.commit();
		}
		return res;
	}
	
	public int insertEnumStudentWithAPI(Student student) {
		log.debug("insertStudentWithAPI()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertEnumStudentWithAPI", student);
			sqlSession.commit();
		}
		return res;
	}
	
	public int updateStudentWithAPI(Student student) {
		log.debug("updateStudentWithAPI()");
		int res = -1;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try  {
			res = sqlSession.update(namespace + "updateStudentWithAPI", student);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return res;
	}
	
	public int updateSetStudentWithAPI(Student student) {
		log.debug("updateSetStudentWithAPI()");
		int res = -1;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try  {
			res = sqlSession.update(namespace + "updateSetStudentWithAPI", student);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteStudentWithAPI(int no) {
		log.debug("deleteStudentWithAPI()");
		int res = -1;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try  {
			res = sqlSession.delete(namespace + "deleteStudentWithAPI", no);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Student> selectStudentByAllForResultMapWithAPI() {
		log.debug("selectStudentByAllForResultMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllForResultMapWithAPI");
		}
	}
	
	public List<Map<String, Object>> selectStudentByAllForMapWithAPI() {
		log.debug("selectStudentByAllForResultMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllForMapWithAPI");
		}
	}
	
	public Student selectStudentByNoForResultMapExtendsWithAPI(Student student) {
		log.debug("selectStudentByNoForResultMapExtendsWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoForResultMapExtendsWithAPI", student);
		}
	}
	
	public Student selectStudentByNoForAssociationWithAPI(Student student) {
		log.debug("selectStudentByNoForAssociationWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoForAssociationWithAPI", student);
		}
	}
	
	public Student findAllStudentByStudentWithAPI(Student student) {
		log.debug("findAllStudentByStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAllStudentByStudentWithAPI", student);
		}
	}
	public Student findAllStudentByMapWithAPI(Map<String, String> map) {
		log.debug("findAllStudentByMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAllStudentByMapWithAPI", map);
		}
	}
	
	public Map<Integer, String> findStudentForMapWithAPI() {
		log.debug("findStudentForMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			Map<Integer, String> map = new HashMap<>();
			ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
				@Override
				public void handleResult(ResultContext<? extends Student> resultContext) {
					Student student = resultContext.getResultObject();
					map.put(student.getStudId(), student.getName());
				}
			};
			sqlSession.select(namespace + "selectStudentForMapWithAPI", resultHandler);
			return map;
		}
	}
}
