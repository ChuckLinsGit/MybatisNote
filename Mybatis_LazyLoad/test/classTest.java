package test;
	
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.MybatisUtil;
import Invi.mybatis.DAO.Group2GroupDAO;
import Invi.mybatis.DAO.Group2OneDAO;
import Invi.mybatis.DAO.One2GroupDAO;
import Invi.mybatis.DAO.Self2SelfDAO;
import Invi.mybatis.bean.ClassPosition4Self2Self;
import Invi.mybatis.bean.SchoolClass4Group2Group;
import Invi.mybatis.bean.SchoolClass4One2Group;
import Invi.mybatis.bean.Student4Group2One;

public class classTest {
	private	SqlSession sqlSession;
	private One2GroupDAO classDAO;
	private Group2OneDAO stuDAO;
	private Self2SelfDAO positionDAO;
	private Group2GroupDAO linkDAO;

	@Before
	public void before(){
		sqlSession=new MybatisUtil().getSqlSession();
		classDAO=sqlSession.getMapper(One2GroupDAO.class);
		stuDAO=sqlSession.getMapper(Group2OneDAO.class);
		positionDAO=sqlSession.getMapper(Self2SelfDAO.class);
		linkDAO=sqlSession.getMapper(Group2GroupDAO.class);
	}
	@After
	public void after(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
	/**
	 * 一对多-单独查询
	 */
	@Test
	public void testGetStudentInClassWithCollectionSeperateQuerry(){
		SchoolClass4One2Group clazz;
		clazz=classDAO.getStudentInClassWithCollectionSeperateQuerry(3);
		System.out.println(clazz.getCid());
		System.out.println(clazz.getStudents().getClass());
	}

}
