package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.AddressDao;
import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static AddressService instance = new AddressService();
	private static final Log log = LogFactory.getLog(AddressService.class);
	
	public static AddressService getInstance() {
		return instance;
	}

	private AddressService() {
	}

	public List<Address> selectAddressByAll(RowBounds rowBounds) {
		log.debug("selectAddressByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressByAll(rowBounds);
		}
	}
	
	public List<Address> findAddressByLimit(Map<String, Integer> map) {
		log.debug("selectAddressByLimit()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressByLimit(map);
		}
	}
}
