package com.bmdb.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String title;
	private int year;
	private String rating;
	private String director;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(int id, String title, int year, String rating, String director) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.director = director;
	}





	public Movie(String title, int year, String rating, String director) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.director = director;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}


	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}


	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}


	@Override
	public String toString() {
		return "id=" + id + ", title=" + title + ", year=" + year + ", rating=" + rating + ", director="
				+ director;
	}





		
	
}
