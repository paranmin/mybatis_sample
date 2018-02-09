package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

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
}
