package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import utils.MybatisUtil;
import Invi.mybatis.DAO.studentDAO;
import Invi.mybatis.bean.Student;

public class studentTest {

	private studentDAO stuDAO;
	private SqlSession sqlSession;
	@Before
	public void before(){
		PropertyConfigurator.configure("src/log4j.properties");
		Logger logger = Logger.getLogger(studentTest.class);
		sqlSession=new MybatisUtil().getSqlSession();
		stuDAO=sqlSession.getMapper(studentDAO.class);
		//sqlSession.getConfiguration().addMapper(studentDAO.class);
	}
	
	@Test
	public void  testSaveStudentCache(){
		try{			
			Student student = new Student(null,"ÓÚÁè³¿",20,59);
			
			List<Student> students=new ArrayList<Student>();
			Student st1=new Student(null,"²ÝÄàÂí",1,0);
			Student st2=new Student(null,"ÄàÂê²Ý",1,0);
			Student st3=new Student(null,"Âí²ÝÄà",1,0);
			students.add(st1);
			students.add(st2);
			students.add(st3);
			
			for(Student stu:students){				
				stuDAO.saveStudentCache(stu);
			}
			
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testDeleteStudentForConditions(){
		try{
			
			Map<String,String> forName=new HashMap<String,String>();
			forName.put("value","ÓÚÁè³¿");
			forName.put("condition","name");
			stuDAO.deleteStudentForConditions(forName);
			
			//stuDAO.deleteStudentForConditions("name","ÓÚÁè³¿");
			sqlSession.commit();			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	@Test
	public void testUpdateStudent(){
		try{			
			Student student = new Student(13,"ÓÚÁè³¿",20,49);
			stuDAO.updateStudent(student);
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testgetAllStudents(){
		try{			

			List<Student> students=stuDAO.getAllStudents();
			for(Student stu:students){
				System.out.println(stu);
			}
//			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void testGetForValueById(){
		try{			
			Integer value=stuDAO.getForValueById(0);
				System.out.println(value);
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}	
	}
}
