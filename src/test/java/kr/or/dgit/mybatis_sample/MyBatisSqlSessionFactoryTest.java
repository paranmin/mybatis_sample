package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest {
	private static SqlSessionFactory factory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDwonAfterClass() throws Exception {
		factory = null;
	}
	
	@Test
	public void testFactory() {
		assertNotNull(factory);
	}
	
	@Test
	public void testSession() {
		assertNotNull(factory.openSession());
	}

}
