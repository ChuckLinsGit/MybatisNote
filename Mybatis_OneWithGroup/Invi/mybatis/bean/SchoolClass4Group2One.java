package Invi.mybatis.bean;

import java.util.Set;

public class SchoolClass4Group2One {

	private Integer cid;
	private Integer sumofstu;
	
	public SchoolClass4Group2One(Integer cid, Integer sumofstu, Set<Student4One2Group> student4One2Groups) {
		super();
		this.cid = cid;
		this.sumofstu = sumofstu;
	}

	public SchoolClass4Group2One() {
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

	@Override
	public String toString() {
		return "SchoolClass [cid=" + cid + ", sumofstu=" + sumofstu+"]";
	}
	
	
}
