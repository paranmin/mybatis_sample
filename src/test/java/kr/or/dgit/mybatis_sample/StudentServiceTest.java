package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	public void test1FindStudent() {
		Student std = new Student(1);
		Student student = service.findStudent(std);
		assertNotNull(student);
		assertEquals(std.getStudId(), student.getStudId());
		System.out.println(student);
	}

	@Test
	public void test2FindStudentAll() {
		List<Student> listStd = service.findStudentByAll();
		assertNotNull(listStd);
		for (Student std : listStd) {
			System.out.println(std);
		}
	}
	
	@Test
	public void test3InsertStudent() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동1");
		std.setEmail("hongidong1@test.com");
		std.setPhone(new PhoneNumber("010-1111-2222"));
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2018, 5, 10);
		std.setDob(newDate.getTime());
		
		int res = service.insertStudent(std);
		assertEquals(1, res);
	}
	
	@Test
	public void test4UpdateStudent() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동1");
		std.setEmail("test1@test.com");
		std.setPhone(new PhoneNumber("010-999-1111"));
		std.setDob(new Date());
		
		int res = service.updateStudent(std);
		assertEquals(1, res);
	}
	
	@Test
	public void test5DeleteStudent() {
		int res = service.deleteStudent(3);
		assertEquals(1, res);
	}
	
	@Test
	public void test6selectStudentByAllForResultMap() {
		List<Student> lists = service.selectStudentByAllForResultMap();
		List<Student> listStd = service.findStudentByAll();
		
		assertSame(lists.size(), listStd.size());
	}
	
	@Test
	public void test7selectStudentByAllForHashMap() {
		List<Map<String,Object>> listMaps = service.selectStudentByAllForHashMap();
		List<Student> listStd = service.findStudentByAll();
		
		assertSame(listMaps.size(), listStd.size());
		
		for (Map<String, Object> map : listMaps) {
			for (Entry<String, Object> e : map.entrySet()) {
				System.out.printf("Key %s => Value %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	@Test
	public void test8SelectStudentByNoForResultMapExtends() {
		Student student = new Student();
		student.setStudId(1);
		
		Student extStd = service.selectStudentByNoForResultMapExtends(student);
		assertEquals(1, extStd.getStudId());
		System.out.println(extStd);
	}
	
	@Test
	public void test9SelectStudentByNoAccociation() {
		Student student = new Student();
		student.setStudId(1);
		
		Student extStd = service.selectStudentByNoAccociation(student);
		assertEquals(1, extStd.getStudId());
		System.out.println(extStd);
	}
	
	@Test
	public void testAInsertEnumStudent() {
		Student std = new Student();
		std.setStudId(3);
		std.setName("홍길동1");
		std.setEmail("hongidong1@test.com");
		std.setPhone(new PhoneNumber("010-1111-2222"));
		std.setGender(Gender.FEMALE);
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(2018, 5, 10);
		std.setDob(newDate.getTime());
		
		int res = service.insertEnumStudent(std);
		assertEquals(1, res);
		
		test5DeleteStudent();
	}
}
