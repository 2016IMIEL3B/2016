/**
 * 
 */
package model;

import java.util.Date;

/**
 * @author Enzo
 *
 */
public class Insurance {
	int id;
	String name;
	Date created_date;
	int price;
	String summary;
	int step;
	enum Statement { 
		IN_PROGRESS, CLOSED
	}
	Statement statement;
	User user;
	
	public Insurance(String name, Date created_date, int price, String summary, int step, Statement statement,
			User user) {
		super();
		this.name = name;
		this.created_date = created_date;
		this.price = price;
		this.summary = summary;
		this.step = step;
		this.statement = statement;
		this.user = user;
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
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
