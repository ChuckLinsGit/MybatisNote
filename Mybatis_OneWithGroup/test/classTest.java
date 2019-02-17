package test;
	
import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
	
	@Test
	public void testGetStudentInClassWithCollectionQuerry(){
		List<SchoolClass4One2Group> clazz;
		try{
			clazz=classDAO.getStudentInClassWithCollectionQuerry(3);
			sqlSession.commit();
			for(SchoolClass4One2Group cla:clazz){
				System.out.println(cla);
			}
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetStudentInClassWithCollectionSeperateQuerry(){
		List<SchoolClass4One2Group> clazz;
		try{
			clazz=classDAO.getStudentInClassWithCollectionSeperateQuerry(3);
			sqlSession.commit();
			for(SchoolClass4One2Group cla:clazz){
				System.out.println(cla);
			}
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
		
	@Test
	public void testGetClassOfStudentWithAssociationQUerry(){
		List<Student4Group2One> stus;
		try{
			stus=stuDAO.getStudentInClassWithAssociationQuerry(3);
			sqlSession.commit();
			for(Student4Group2One stu:stus){
				System.out.println(stu);
			}
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetClassOfStudentWithAssociationSelepateQuerry(){
		List<Student4Group2One> stus;
		try{
			stus=stuDAO.getStudentInClassWithAssociationSeperateQuerry(3);
			sqlSession.commit();
			for(Student4Group2One stu:stus){
				System.out.println(stu);
			}
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetClassUnderlingPositionById(){
		List<ClassPosition4Self2Self> underling;
		try{
			underling=positionDAO.getUnderlingPositionById(1);
			for(ClassPosition4Self2Self position:underling){
				System.out.println(position);
			}
			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetClassPositionById(){
		List<ClassPosition4Self2Self> underling;
		try{
			underling=positionDAO.getPositionSystemById(1);
			for(ClassPosition4Self2Self position:underling){
				System.out.println(position);
			}
			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testgetStudentsInClassById(){
		List<SchoolClass4Group2Group> clazz;
		try{
			clazz=linkDAO.getStudentsInClassById(1);
			for(SchoolClass4Group2Group x:clazz){
				System.out.println(x);
			}
			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
