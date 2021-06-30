/**
 * 
 */
package com.rockcor.model;

/**
 * @author ricardodelgadocarreno
 *
 */
public class Libro {

	private String name;
	private String gender;
	private int pages;

	/**
	 * 
	 */
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param gender
	 * @param pages
	 */
	public Libro(String name, String gender, int pages) {
		super();
		this.name = name;
		this.gender = gender;
		this.pages = pages;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

}
