package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.MybatisUtil;
import Invi.mybatis.DAO.studentDAO;
import Invi.mybatis.bean.Student;

public class studentTest {

	private studentDAO stuDAO;
	private SqlSession sqlSession;
	private MybatisUtil utis=new MybatisUtil();
	@Before
	public void before(){
		
		sqlSession=utis.getSqlSession();
		stuDAO=sqlSession.getMapper(studentDAO.class);
		//sqlSession.getConfiguration().addMapper(studentDAO.class);
	}
	
	@After
	public void after(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
	
	@Test
	public void  testSaveStudentCache(){
			Student student = new Student(null,"���賿",20,59,1);
			
			List<Student> students=new ArrayList<Student>();
			Student st1=new Student(null,"������",1,0,2);
			Student st2=new Student(null,"�����",1,0,3);
			Student st3=new Student(null,"�����",1,0,4);
			students.add(st1);
			students.add(st2);
			students.add(st3);
			
			for(Student stu:students){				
				stuDAO.saveStudentCache(stu);
			}
			
			sqlSession.commit();
	}
	/*��ͬ�����ռ�Ļ��滥�����ţ���ͬ�����ռ�Ļ������ͬһ��������
	 * 
	 * һ������Ͷ������������
	 		I.sessionһ���رգ�һ��������գ�������������Ȼ���ڣ�Ҳ����˵��һ��������ͬһsession
	�й������������ڲ�ͬsessionͬ��Ӧ�ó����ڹ���
	 		II.һ������Ĭ�Ͽ�������session�ر�ǰһֱ���ڣ����Դ��Ķ�������ҲĬ�Ͽ�������Ҫ��ʵ����ʵ�����л�
������mapper.xml������<cache/>��ǩ������Ҳ������mybatis-config.xml���ùرգ��ҿ����ڹر��Դ��Ķ�����������
��ʹ�õ��������棨�������л�������Ҫ��mapper.xml�����ã�
	
	/**
	 * һ������
	 */
	@Test
	public void testSqlSessionCache(){
		
			Student stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
//			stu=stuDAO.getSingleStudent(3);
//			System.out.println(stu.getName());
			
			//����֤��
			stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
			//����ʵ�ʣ�һ��hashmap��keyΪ�������ݣ�valueΪ��ѯ��װ���
			//һ���������ݣ������Hashֵ+sql���+�������
			//������������sql��䲻ͬ�����������Ĳ�ѯ�ǲ�ͬ�Ļ���
//			stu=stuDAO.getSingleStudent2(2);
//			System.out.println(stu.getName());
			
			//��ɾ�Ļ�ˢ��һ������,�������²�ѯ
			//ʵ�ʣ���������Ƕ�map��valueֵ��null������ɾ��Entry����
			Student st=new Student(null,"������",1,0,1);
			stuDAO.saveStudentCache(st);
//			sqlSession.commit();�����Ƿ��ύ���񶼻ᵼ��ˢ��
			
			stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
	}
	
	
	/**
	 * ��������
	 */
	@Test
	public void testSecondlevelCacheBeforeSetting(){

		Student stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
		stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
		sqlSession.close();
		sqlSession=utis.getSqlSession();
		stuDAO=sqlSession.getMapper(studentDAO.class);
		
		stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
	/*	[DEBUG][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==> Parameters: 2(Integer)
		[TRACE][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==    Columns: sid, name, age, score, classid
		[TRACE][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==        Row: 2, ������, 22, 60, 1
		[DEBUG][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 <==      Total: 1
		������
		������
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==> Parameters: 2(Integer)
		[TRACE][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==    Columns: sid, name, age, score, classid
		[TRACE][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==        Row: 2, ������, 22, 60, 1
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 <==      Total: 1
		������
	*/
		
	}
	
	/**
	 * ��������
	 */
	@Test
	public void testSecondlevelCacheAfterSetting(){

		Student stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
//		
//		stu=stuDAO.getSingleStudent(2);
//		System.out.println(stu.getName());
		
		sqlSession.close();
		
		sqlSession=utis.getSqlSession();
		stuDAO=sqlSession.getMapper(studentDAO.class);
		
		stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
		//��ɾ�Ļ�ˢ�¶�������,�������²�ѯ�����������ǲ���Ӱ���
		//ԭ����������Ƕ�map��valueֵ��null������ɾ��Entry����
		//����key�������ţ���hit rate����key���м��㣬���Բ���Ӱ��
		Student st=new Student(null,"������",1,0,1);
		stuDAO.saveStudentCache(st);
//		sqlSession.commit();�����Ƿ��ύ���񶼻ᵼ��ˢ��
		
		stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
/*		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.0
		[DEBUG]==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG]==> Parameters: 2(Integer)
		[DEBUG]<==      Total: 1
		������
		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.5
		������
		[DEBUG]==>  Preparing: INSERT INTO STUDENT (SID,NAME,AGE,SCORE,ClASSID) VALUES (?,?,?,?,?) 
		[DEBUG]==> Parameters: null, ������(String), 1(Integer), 0(Integer), 1(Integer)
		[DEBUG]<==    Updates: 1
		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.6666666666666666
		[DEBUG]==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG]==> Parameters: 2(Integer)
		[DEBUG]<==      Total: 1
		������
*/
	}
}
