package es.uniovi.electoral.model;

public class PollingStation {

	private long code;
	private String province;
	private String city;
	private String district;
	private String country;
	
	public PollingStation(long code, String province, String city,
			String district, String country) {
		super();
		this.code = code;
		this.province = province;
		this.city = city;
		this.district = district;
		this.country = country;
	}

	public long getCode() {
		return code;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getCountry() {
		return country;
	}	
}
