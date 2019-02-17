package Invi.mybatis.DAO;

import java.util.List;
import java.util.Map;

import Invi.mybatis.bean.Student;

public interface studentDAO<T> {
	
	public List<Student> getStudentByConditionsWithIf(Map map);

	public List<Student> getStudentByConditionsWithWhere(Map map);
	
	public List<Student> getStudentByConditionsWithWhere(Student stu);
	
	public List<Student> getStudentByConditionsWithChoose(Student stu);
	
	public List<Student> getStudentByConditionsWithForeach(List<T> students);
	
	
}
