package com.bmdb.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate birthday;
	
	public Actor() {
		super();
		
	}
	
	public Actor(int id, String firstName, String lastName, String gender, LocalDate birthday) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	public Actor(String firstName, String lastName, String gender, LocalDate birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", birthday=" + birthday + "]";
	}
	
	
	
	
}
