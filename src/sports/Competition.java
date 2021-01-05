package sports;

import java.util.ArrayList;
import java.util.List;

public class Competition {
	private String name=null;
	private Integer number=0;
	private String content=null;
	private Boolean avalible=null;
	public Competition() {
	}
	private List<User> usersList=new ArrayList<User>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getAvalible() {
		return avalible;
	}
	public void setAvalible(Boolean avalible) {
		this.avalible = avalible;
	}
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	@Override
	public String toString() {
		return "Competition [name=" + name + ", content=" + content + ", avalible=" + avalible + "]";
	}
	public Competition(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}
}
