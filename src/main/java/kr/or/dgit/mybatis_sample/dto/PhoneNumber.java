package kr.or.dgit.mybatis_sample.dto;

public class PhoneNumber {
	private String countryCode;
	private String stateCode;
	private String number;

	public PhoneNumber() {}
	
	public PhoneNumber(String phoneNumber) {
		if (phoneNumber != null) {
			String[] parts = phoneNumber.split("-");
			
			if (parts.length > 0) {
				this.countryCode = parts[0];
			}
			if (parts.length > 1) {
				this.stateCode = parts[1];
			}
			if (parts.length > 2) {
				this.number = parts[2];
			}
		}
	}

	public PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%s", countryCode, stateCode, number);
	}

}
