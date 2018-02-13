package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final TutorService instance = new TutorService();
	private static final Log log = LogFactory.getLog(TutorService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.TutorDao.";

	public static TutorService getInstance() {
		return instance;
	}

	private TutorService() {}

	public Tutor findTutorByTutorIdWithAPI(Tutor tutor) {
		log.debug("API findTutorByTutorIdWithAPI(Tutor tutor)");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectTutorByTutorIdWithAPI", tutor);
		}
	}
}
