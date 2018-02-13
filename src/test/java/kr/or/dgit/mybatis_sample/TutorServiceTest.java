package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.service.TutorService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorServiceTest {
	private static TutorService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = TutorService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindTutorByTutorId() {
		Tutor tutor = new Tutor();
		tutor.setTutorId(1);
		
		Tutor findTutor = service.findTutorByTutorId(tutor);
		
		assertEquals(tutor.getTutorId(), findTutor.getTutorId());
		System.out.println(findTutor);
	}

}
