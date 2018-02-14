package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

	@Test
	public void test2FindAddressByLimit() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 3);
		List<Address> lists = service.findAddressByLimit(map);
		assertNotNull(lists);
		
		System.out.println(lists.size());
		
		for (Address addr : lists) {
			System.out.println(addr);
		}
	}
	
	@Test
	public void test3FindAddressByLimit() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 3);
		map.put("limit", 3);
		List<Address> lists = service.findAddressByLimit(map);
		assertNotNull(lists);
		
		System.out.println(lists.size());
		
		for (Address addr : lists) {
			System.out.println(addr);
		}
	}
}
