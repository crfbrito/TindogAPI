package com.carlos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private int matchId;
	@Column
	private String password;
	@Column
	private int locationId;
	@Column
	private String preferredGender;
	@Column
	private String preferredAgeMin;
	@Column
	private String preferredAgeMax;
	@Column
	private String preferredDistance;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private String pictures;
	@Column
	private String description;
	@Column
	private String interests;
	@Column
	private String connections;
	@Column
	private String reportedUser;

	public User() {
		super();

	}

	public User(int uid, String name, String email, int matchId, String password, int locationId,
			String preferredGender, String preferredAgeMin, String preferredAgeMax, String preferredDistance, int age,
			String gender, String pictures, String description, String interests, String connections,
			String reportedUser) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.matchId = matchId;
		this.password = password;
		this.locationId = locationId;
		this.preferredGender = preferredGender;
		this.preferredAgeMin = preferredAgeMin;
		this.preferredAgeMax = preferredAgeMax;
		this.preferredDistance = preferredDistance;
		this.age = age;
		this.gender = gender;
		this.pictures = pictures;
		this.description = description;
		this.interests = interests;
		this.connections = connections;
		this.reportedUser = reportedUser;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getPreferredGender() {
		return preferredGender;
	}

	public void setPreferredGender(String preferredGender) {
		this.preferredGender = preferredGender;
	}

	public String getPreferredAgeMin() {
		return preferredAgeMin;
	}

	public void setPreferredAgeMin(String preferredAgeMin) {
		this.preferredAgeMin = preferredAgeMin;
	}

	public String getPreferredAgeMax() {
		return preferredAgeMax;
	}

	public void setPreferredAgeMax(String preferredAgeMax) {
		this.preferredAgeMax = preferredAgeMax;
	}

	public String getPreferredDistance() {
		return preferredDistance;
	}

	public void setPreferredDistance(String preferredDistance) {
		this.preferredDistance = preferredDistance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getConnections() {
		return connections;
	}

	public void setConnections(String connections) {
		this.connections = connections;
	}

	public String getReportedUser() {
		return reportedUser;
	}

	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + uid + ", name=" + name + ", email=" + email + "]";
	}

}
