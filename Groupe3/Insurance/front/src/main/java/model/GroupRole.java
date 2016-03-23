/**
 * 
 */
package model;

/**
 * @author Enzo
 *
 */
public class GroupRole {
	Group group;
	Role role;
	
	public GroupRole(Group group, Role role) {
		super();
		this.group = group;
		this.role = role;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
