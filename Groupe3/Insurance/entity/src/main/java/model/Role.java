/**
 * 
 */
package model;

/**
 * @author Enzo
 *
 */
public class Role {
	int id;
	String name;
	
	public Role(String name) {
		super();
		this.name = name;
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
}
