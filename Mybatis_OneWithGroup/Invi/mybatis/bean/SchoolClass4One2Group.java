package Invi.mybatis.bean;

import java.util.Set;

public class SchoolClass4One2Group {

	private Integer cid;
	private Integer sumofstu;
	private Set<Student4One2Group> student4One2Groups;
	
	public SchoolClass4One2Group(Integer cid, Integer sumofstu, Set<Student4One2Group> student4One2Groups) {
		super();
		this.cid = cid;
		this.sumofstu = sumofstu;
		this.student4One2Groups = student4One2Groups;
	}

	public SchoolClass4One2Group() {
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

	public Set<Student4One2Group> getStudents() {
		return student4One2Groups;
	}

	public void setStudents(Set<Student4One2Group> student4One2Groups) {
		this.student4One2Groups = student4One2Groups;
	}

	@Override
	public String toString() {
		return "SchoolClass [cid=" + cid + ", sumofstu=" + sumofstu
				+ ", students=" + student4One2Groups + "]";
	}
	
	
}
