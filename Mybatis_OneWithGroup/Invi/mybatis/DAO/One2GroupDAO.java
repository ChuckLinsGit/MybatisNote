package Invi.mybatis.DAO;

import java.util.List;	

import Invi.mybatis.bean.SchoolClass4One2Group;

public interface One2GroupDAO {

	public List<SchoolClass4One2Group> getStudentInClassWithCollectionQuerry(Integer cid);
	public List<SchoolClass4One2Group> getStudentInClassWithCollectionSeperateQuerry(Integer cid);
}
