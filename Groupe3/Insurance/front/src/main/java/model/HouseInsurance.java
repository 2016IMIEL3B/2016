/**
 * 
 */
package model;

import java.util.Date;

import model.Insurance;

/**
 * @author Enzo
 *
 */
public class HouseInsurance extends Insurance {
	int id;
	int option;
	
	public HouseInsurance(String name, Date created_date, int price, String summary, int step, Statement statement,
			User user, int option) {
		super(name, created_date, price, summary, step, statement, user);
		this.option = option;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}
}
