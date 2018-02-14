package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.service.AddressService;

public class AddressServiceTest {
	private static AddressService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = AddressService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1SelectAddressByAll() {
		RowBounds rowBounds = new RowBounds(0, 3);
		List<Address> lists = service.selectAddressByAll(rowBounds);
		assertNotNull(lists);
		
		System.out.println(lists);
		
		for (Address addr : lists) {
			System.out.println(addr);
		}
	}

}
