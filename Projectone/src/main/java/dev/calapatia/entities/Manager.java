package dev.calapatia.entities;

public class Manager {
	
	private int mId;
	private String username;
	private String password;
	private boolean isManager;

	public Manager() {
		super();
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
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
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", username=" + username + ", password=" + password + ", isManager=" + isManager
				+ "]";
	}

	

	
}
