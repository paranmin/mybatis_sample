package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;
import kr.or.dgit.mybatis_sample.type.Gender;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindStudentWithAPI() {
		Student std = new Student(1);
		Student student = service.findStudentWithAPI(std);
		assertNotNull(student);
		assertEquals(std.getStudId(), student.getStudId());
		System.out.println(student);
	}

	@Test
	public void test2FindStudentAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		assertNotNull(listStd);
		for (Student std : listStd) {
			System.out.println(std);
		}
	}
	
	@Test
	public void test3InsertStudentWithAPI() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동2");
		std.setEmail("hongidong2@test.com");
		std.setPhone(new PhoneNumber("010-3333-4444"));
		System.out.println(std);
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2020, 5, 10);
		std.setDob(newDate.getTime());
		int res = service.insertStudentWithAPI(std);
		assertEquals(1, res);
	}
	
	@Test
	public void test4UpdateStudentWithAPI() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동2");
		std.setEmail("test2@test.com");
		std.setPhone(new PhoneNumber("010-555-7777"));
		std.setDob(new Date());
		
		System.out.println(std);
		int res = service.updateStudentWithAPI(std);
		assertEquals(1, res);
	}
	
	@Test
	public void test5DeleteStudentWithAPI() {
		int res = service.deleteStudentWithAPI(3);
		assertEquals(1, res);
	}
	
	@Test
	public void test6selectStudentByAllForResultMapWithAPI() {
		List<Student> lists = service.selectStudentByAllForResultMapWithAPI();
		List<Student> listStd = service.findStudentByAllWithAPI();
		
		assertSame(listStd.size(), lists.size());
	}
	
	@Test
	public void test7selectStudentByAllForMapWithAPI() {
		List<Map<String, Object>> listMaps = service.selectStudentByAllForMapWithAPI();
		List<Student> listStd = service.findStudentByAllWithAPI();
		
		assertSame(listStd.size(), listMaps.size());
		
		for (Map<String, Object> map : listMaps) {
			for (Entry<String, Object> e : map.entrySet()) {
				System.out.printf("Key ( %s ) : ( %s ) Value %n", e.getKey(), e.getValue());
			}
		}
	}
	
	@Test
	public void test8SelectStudentByNoForResultMapExtendsWithAPI() {
		Student std = new Student(1);
		Student student = service.selectStudentByNoForResultMapExtendsWithAPI(std);
		
		assertNotNull(student);
		assertEquals(std.getStudId(), student.getStudId());
		System.out.println(student);
	}
	
	@Test
	public void test9selectStudentByNoForAssociationWithAPI() {
		Student std = new Student(1);
		Student student = service.selectStudentByNoForAssociationWithAPI(std);
		
		assertNotNull(student);
		assertEquals(std.getStudId(), student.getStudId());
		System.out.println(student);
	}
	
	@Test
	public void testAinsertEnumStudentWithAPI() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동2");
		std.setEmail("hongidong2@test.com");
		std.setPhone(new PhoneNumber("010-3333-4444"));
		std.setGender(Gender.FEMALE);
		System.out.println(std);
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2020, 5, 10);
		std.setDob(newDate.getTime());
		
		int res = service.insertEnumStudentWithAPI(std);
		assertEquals(1, res);
		
		service.deleteStudentWithAPI(3);
	}
	
	@Test
	public void testBFindAllStudentByStudentWithAPI() {
		Student std = new Student();
		std.setName("Timothy");
		std.setEmail("timothy@gmail.com");
		
		Student findStd = service.findAllStudentByStudentWithAPI(std);
		assertNotNull(findStd);
		
		assertEquals(std.getName(), findStd.getName());
		System.out.println(findStd);
	}
	
	@Test
	public void testCFindAllStudentByMapWithAPI() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "Timothy");
		map.put("email", "timothy@gmail.com");
		
		Student findStd = service.findAllStudentByMapWithAPI(map);
		assertNotNull(findStd);
		
		assertEquals(map.get("name"), findStd.getName());
		System.out.println(findStd);
	}
	
	@Test
	public void testDFindStudentForMapWithAPI() {
		Map<Integer, String> map = service.findStudentForMapWithAPI();
		assertNotNull(map);
		
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.printf("Key(%s) : Value(%s) %n", entry.getKey(), entry.getValue());
		}
	}
	
	@Test
	public void testEUpdateSetStudentWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("943-142-3521"));
		student.setDob(new Date());
		
		int res = service.updateSetStudentWithAPI(student);
		assertSame(1, res);
		
		student.setPhone(new PhoneNumber("123-112-1234"));
		student.setDob(new GregorianCalendar(1988,12,4).getTime());
		
		res = service.updateSetStudentWithAPI(student);
		assertSame(1, res);
	}
}
