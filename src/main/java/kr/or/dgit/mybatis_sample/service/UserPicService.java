package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final UserPicService instance = new UserPicService();
	private static Log log = LogFactory.getLog(UserPicService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.UserPicDao.";

	public static UserPicService getInstance() {
		return instance;
	}

	private UserPicService() {
	}

	public int createUserPic(UserPic userPic) {
		log.debug("createUserPic(UserPic userPic)");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertUserPic", userPic);
			sqlSession.commit();
		}
		return res;
	}
	
	public UserPic findUserPic(UserPic userPic) {
		log.debug("findUserPic(UserPic userPic)");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "getUserPic", userPic);
		}
	}
}
