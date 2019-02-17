package Invi.mybatis.DAO;

import java.util.List;	
import java.util.Map;

import Invi.mybatis.bean.Student;

public interface studentDAO {
	
	@insert("INSERT INTO STUDENT (ID,NAME,AGE,SCORE) VALUES (#{id},#{name},#{age},#{score})")
	public void saveStudentCache(Student student);
	
	@update("DELETE FROM STUDENT WHERE ${condition}=#{value}")
	//public void deleteStudentForConditions(@Param(value="condition") String condition,@Param(value="value") String value);
	public void deleteStudentForConditions(Map map);
	
	@update("DELETE FROM STUDENT WHERE ${condition}=#{value}")
	public void updateStudent(Student student);

	@select("SELECT * FROM STUDENT")
	public List<Student> getAllStudents();

	
}
