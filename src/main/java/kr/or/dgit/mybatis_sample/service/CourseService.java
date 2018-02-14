package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class CourseService {
	private static final CourseService instance = new CourseService();
	private static final Log log = LogFactory.getLog(CourseService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.CourseDao.";
	
	public static CourseService getInstance() {
		return instance;
	}

	private CourseService() {
	}

	public List<Course> findCoursesByCondition(Map<String, Object> map) {
		log.debug("findCoursesByCondition");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectCoursesByCondition", map);
		}
	}
	
	public List<Course> findCaseCourses(Map<String, Object> map) {
		log.debug("findCaseCourses");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectCaseCourses", map);
		}
	}
	
	public List<Course> findWhereCourses(Map<String, Object> map) {
		log.debug("findWhereCourses");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectWhereCourses", map);
		}
	}
	
	public List<Course> findTrimCourses(Map<String, Object> map) {
		log.debug("findTrimCourses");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectTrimCourses", map);
		}
	}
	
	public List<Course> findCoursesForeachByTutors(Map<String, Object> map) {
		log.debug("findCoursesForeachByTutors");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectCoursesForeachByTutors", map);
		}
	}
}
