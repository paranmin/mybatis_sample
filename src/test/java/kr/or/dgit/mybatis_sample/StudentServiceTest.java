package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

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

}
