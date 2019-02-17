package Invi.mybatis.DAO;

import java.util.List;

import Invi.mybatis.bean.SchoolClass4Group2Group;
import Invi.mybatis.bean.Student4Group2Group;

public interface Group2GroupDAO {
	public List<SchoolClass4Group2Group> getStudentsInClassById(Integer id);
	public List<Student4Group2Group> getClassOfStudentById(Integer id);
}
