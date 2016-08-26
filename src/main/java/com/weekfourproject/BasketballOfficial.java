package com.weekfourproject;

public class BasketballOfficial {
	
	private String officialID = null;
	private String lastName = null;
	private String firstName = null;
	private String phoneNumber = null;
	private String departureLocation = null;
	
	public BasketballOfficial() {
		super();
	}//empty constructor

	public String getOfficialID() {
		return officialID;
	}

	public void setOfficialID(String officialID) {
		this.officialID = officialID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	@Override
	public String toString() {
		return "BasketballOfficial [officialID=" + officialID + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", phoneNumber=" + phoneNumber + ", departureLocation=" + departureLocation + "]";
	}
	
	

}//main
