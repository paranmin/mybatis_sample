package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.service.CourseService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceTest {
	private static CourseService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = CourseService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindCoursesByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<>();
		map.put("tutorId", 1);
		map.put("name", "%java%");
		map.put("startDate", cal.getTime());
		
		List<Course> courses = service.findCoursesByCondition(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	public void test2FindCaseCourses() {
		Map<String, Object> map = new HashMap<>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		
		List<Course> courses = service.findCaseCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.remove("tutorId");
		map.replace("searchBy", "CourseName");
		map.put("name", "%java%");
		
		courses = service.findCaseCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	public void test3FindWhereCourses() {
		Map<String, Object> map = new HashMap<>();
		
		List<Course> courses = service.findWhereCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.put("tutorId", 1);
		courses = service.findWhereCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}

		map.put("name", "%java%");
		courses = service.findWhereCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.clear();
		map.put("endDate", new Date());
		courses = service.findWhereCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	public void test4FindTrimCourses() {
		Map<String, Object> map = new HashMap<>();
		
		List<Course> courses = service.findTrimCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.put("tutorId", 1);
		courses = service.findTrimCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
		
		map.put("tutorId", 1);
		map.put("name", "%java%");
		courses = service.findTrimCourses(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	@Test
	public void test5FindCoursesForeachByTutors() {
		List<Integer> tutorIds = new ArrayList<>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<>();
		map.put("tutorIds", tutorIds);
		
		List<Course> courses = service.findCoursesForeachByTutors(map);
		assertNotNull(courses);
		
		for (Course course : courses) {
			System.out.println(course);
		}
	}
}
