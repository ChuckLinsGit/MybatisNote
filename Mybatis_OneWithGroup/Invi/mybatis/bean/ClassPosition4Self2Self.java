package Invi.mybatis.bean;

import java.util.Set;

public class ClassPosition4Self2Self {

	private Integer pid;
	private String  name;
	private String position;
	private Integer manager;
	private Set<ClassPosition4Self2Self> underling;
	
	public ClassPosition4Self2Self() {
		super();
	}

	public ClassPosition4Self2Self(Integer pid, String name, String position,
			Integer manager, Set<ClassPosition4Self2Self> underling) {
		super();
		this.pid = pid;
		this.name = name;
		this.position = position;
		this.manager = manager;
		this.underling = underling;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Set<ClassPosition4Self2Self> getUnderling() {
		return underling;
	}

	public void setUnderling(Set<ClassPosition4Self2Self> underling) {
		this.underling = underling;
	}

	@Override
	public String toString() {
		return "ClassPosition4Self2Self [pid=" + pid + ", name=" + name
				+ ", position=" + position + ", manager=" + manager
				+ ", underling=" + underling + "]";
	} 
}
