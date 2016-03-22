package model;

public class State {
	int id;
	String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public State(String value) {
		super();
		this.value = value;
	}
}
