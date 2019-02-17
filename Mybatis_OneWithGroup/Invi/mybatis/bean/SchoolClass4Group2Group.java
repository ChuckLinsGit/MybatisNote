package Invi.mybatis.bean;

import java.util.Set;

public class SchoolClass4Group2Group {

	private Integer cid;
	private Integer sumofstu;
	private Set<Student4Group2Group> student4Group2Group;
	
	public SchoolClass4Group2Group(Integer cid, Integer sumofstu, Set<Student4Group2Group> student4Group2Group) {
		super();
		this.cid = cid;
		this.sumofstu = sumofstu;
		this.student4Group2Group = student4Group2Group;
	}

	public SchoolClass4Group2Group() {
		super();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getSumofstu() {
		return sumofstu;
	}

	public void setSumofstu(Integer sumofstu) {
		this.sumofstu = sumofstu;
	}

	public Set<Student4Group2Group> getStudents() {
		return student4Group2Group;
	}

	public void setStudents(Set<Student4Group2Group> student4Group2Group) {
		this.student4Group2Group = student4Group2Group;
	}

	@Override
	public String toString() {
		return "SchoolClass [cid=" + cid + ", sumofstu=" + sumofstu
				+ ", students=" + student4Group2Group + "]";
	}
	
	
}
