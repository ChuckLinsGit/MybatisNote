package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
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
		sqlSession=new MybatisUtil().getSqlSession();
		stuDAO=sqlSession.getMapper(studentDAO.class);
		//sqlSession.getConfiguration().addMapper(studentDAO.class);
	}
	
	@Test
	public void  testGetStudentByConditionsWithIf(){
		try{
			Map<String,Integer> map=new HashMap<String,Integer>();
			map.put("id", 0);
			map.put("score", 60);
			List<Student> stus=stuDAO.getStudentByConditionsWithIf(map);
			for(Student stu:stus){
				System.out.println(stu);
			}
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void  testGetStudentByConditionsWithWhere(){
		try{
//			Map<String,Float> map=new HashMap<String,Float>();
//			map.put("id", 2f);
//			map.put("score",0f);//0等同于null
			Student st=new Student(null,"草泥马",1,0);
			List<Student> stus=stuDAO.getStudentByConditionsWithWhere(st);
			for(Student stu:stus){
				System.out.println(stu);
			}
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}

	@Test
	public void  testGetStudentByConditionsWithChoose(){
		try{
//			Map<String,Float> map=new HashMap<String,Float>();
//			map.put("id", 2f);
//			map.put("score",0f);//0等同于null
			Student st=new Student(14,"草泥马",1,0);
			List<Student> stus=stuDAO.getStudentByConditionsWithChoose(st);
			for(Student stu:stus){
				System.out.println(stu);
			}
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void  testGetStudentByConditionsWithForeach(){
		try{
			List<Student> students=new ArrayList<Student>();
			Student st1=new Student(14,"草泥马",1,0);
			Student st2=new Student(15,"泥玛草",1,0);
			Student st3=new Student(16,"马草泥",1,0);
			students.add(st1);
			students.add(st2);
			students.add(st3);
			
			List<Student> stus=stuDAO.getStudentByConditionsWithForeach(students);
			for(Student stu:stus){
				System.out.println(stu);
			}
			sqlSession.commit();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}

}
