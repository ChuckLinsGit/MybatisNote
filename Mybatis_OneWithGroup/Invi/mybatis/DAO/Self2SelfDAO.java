package Invi.mybatis.DAO;

import java.util.List;

import Invi.mybatis.bean.ClassPosition4Self2Self;

public interface Self2SelfDAO {

	public List<ClassPosition4Self2Self> getUnderlingPositionById(Integer id);
	public List<ClassPosition4Self2Self> getPositionSystemById(Integer id);
}
