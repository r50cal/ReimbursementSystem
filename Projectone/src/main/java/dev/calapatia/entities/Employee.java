package dev.calapatia.entities;

public class Employee {
private int eId;
private String name;
private String username;
private String password;
private boolean isManager;

public Employee() {
	super();
}

public int geteId() {
	return eId;
}

public void seteId(int eId) {
	this.eId = eId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public boolean isManager() {
	return false;
}

public void setManager(boolean isManager) {
	this.isManager = isManager;
}

@Override
public String toString() {
	return "Employee [eId=" + eId + ", name=" + name + ", username=" + username + ", password=" + password
			+ ", isManager=" + isManager + "]";
}










}
