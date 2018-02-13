package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.service.UserPicService;

public class UserPicServiceTest {
	private static UserPicService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = UserPicService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1createUserPic() {
		UserPic userPic = new UserPic();
		userPic.setName("윤보미");
		userPic.setBio("여기에 너의 bio를 적으시오");
		userPic.setPic(getPicFile());
		
		int res = service.createUserPic(userPic);
		assertSame(1, res);
	}
	
	private byte[] getPicFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\DataFiles\\pic12_1.jpg");
		try (InputStream is = new FileInputStream(file);) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Test
	public void test2findUserPic() {
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic findUserPic = service.findUserPic(userPic);
		assertNotNull(findUserPic);
		
		assertSame(userPic.getId(), findUserPic.getId());
		System.out.println(findUserPic);
	}

}
