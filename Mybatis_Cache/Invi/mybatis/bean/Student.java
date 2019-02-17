package Invi.mybatis.bean;

import java.io.Serializable;

public class Student {

	private Integer id;
	private String name;
	private Integer age;
	private Integer score;
	private Integer classId;
	
	
	public Student(){
		
	}
	

	public Student(Integer id, String name, Integer age, Integer score,
			Integer classId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.classId = classId;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Integer getClassId() {
		return classId;
	}


	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", score=" + score + ", classId=" + classId + "]";
	}
	

}
