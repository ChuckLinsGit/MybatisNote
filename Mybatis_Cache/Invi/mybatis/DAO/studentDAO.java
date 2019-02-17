package Invi.mybatis.DAO;

import java.util.List;
import java.util.Map;

import Invi.mybatis.bean.Student;

public interface studentDAO {
	
	public void saveStudentCache(Student student);
	
	//public void deleteStudentForConditions(@Param(value="condition") String condition,@Param(value="value") String value);
	public void deleteStudentForConditions(Map map);
	
	public void updateStudent(Student student);

	public List<Student> getAllStudents();
	
	public Student getSingleStudent(Integer id);

	public Student getSingleStudent2(Integer id);
	
	public List<Student> getStudentByConditions(Integer id,Integer score);
	
	public <E>E getForValueById(Integer id);
	
}
