package kr.or.dgit.mybatis_sample.dto;

import java.util.Arrays;

public class UserPic {
	private int id;
	private String name;
	private byte[] pic;
	private String bio;

	public UserPic() {
		// TODO Auto-generated constructor stub
	}

	public UserPic(int id, String name, byte[] pic, String bio) {
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return String.format("UserPic [id=%s, name=%s, pic=%s, bio=%s]", id, name, Arrays.toString(pic), bio);
	}

}
