package com.example.mwidlok.masteringandroidapplication.classes;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by MWidlok on 30.01.2017.
 */

@ParseClassName("JobOffer")
public class JobOffer extends ParseObject {

	public String title;
	private String salary;
	private String location;
	private String imageLink;
	private String type;
	private String description;
	private String company;

	public JobOffer() {
	}

	public String getTitle() {
		return getString("title");
	}

	public void setTitle(String title) {
		put("title",title);
	}

	String getSalary() {
		return salary;
	}

	void setSalary(String salary) {
		this.salary = salary;
	}

	String getLocation() {
		return location;
	}

	void setLocation(String location) {
		this.location = location;
	}

	String getImageLink() {
		return imageLink;
	}

	void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	String getCompany() {
		return company;
	}

	void setCompany(String company) {
		this.company = company;
	}


}
