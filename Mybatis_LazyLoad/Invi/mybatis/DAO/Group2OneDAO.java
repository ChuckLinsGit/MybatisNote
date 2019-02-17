package Invi.mybatis.DAO;

import java.util.List;		

import Invi.mybatis.bean.Student4Group2One;

public interface Group2OneDAO {

	public List<Student4Group2One> getStudentInClassWithAssociationQuerry(Integer cid);
	public List<Student4Group2One> getStudentInClassWithAssociationSeperateQuerry(Integer cid);
}
