package sports;

public class User {
	private String username;
	private String password;
	private boolean avalible=true;
	public boolean isAvalible() {
		return avalible;
	}
	public void setAvalible(boolean avalible) {
		this.avalible = avalible;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", avalible=" + avalible + "]";
	}
}
