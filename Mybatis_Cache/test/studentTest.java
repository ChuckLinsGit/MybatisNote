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
			Student student = new Student(null,"于凌晨",20,59,1);
			
			List<Student> students=new ArrayList<Student>();
			Student st1=new Student(null,"草泥马",1,0,2);
			Student st2=new Student(null,"泥玛草",1,0,3);
			Student st3=new Student(null,"马草泥",1,0,4);
			students.add(st1);
			students.add(st2);
			students.add(st3);
			
			for(Student stu:students){				
				stuDAO.saveStudentCache(stu);
			}
			
			sqlSession.commit();
	}
	/*不同命名空间的缓存互不干扰，相同命名空间的缓存放在同一个缓存区
	 * 
	 * 一级缓存和二级缓存的区别：
	 		I.session一旦关闭，一级缓存清空，而二级缓存仍然存在；也就是说：一级缓存在同一session
	中共享，二级缓存在不同session同个应用程序内共享
	 		II.一级缓存默认开启，在session关闭前一直存在；而自带的二级缓存也默认开启（需要对实体类实现序列化
，并在mapper.xml中配置<cache/>标签），但也可以在mybatis-config.xml配置关闭，且可以在关闭自带的二级缓存的情况
下使用第三方缓存（无需序列化，在需要在mapper.xml中配置）
	
	/**
	 * 一级缓存
	 */
	@Test
	public void testSqlSessionCache(){
		
			Student stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
//			stu=stuDAO.getSingleStudent(3);
//			System.out.println(stu.getName());
			
			//存在证明
			stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
			//缓存实质：一个hashmap，key为缓存依据，value为查询封装结果
			//一级缓存依据：对象的Hash值+sql语句+传入参数
			//下面的语句由于sql语句不同，因此与上面的查询是不同的缓存
//			stu=stuDAO.getSingleStudent2(2);
//			System.out.println(stu.getName());
			
			//增删改会刷新一级缓存,导致重新查询
			//实质：清除缓存是对map的value值赋null，而非删除Entry对象
			Student st=new Student(null,"无名氏",1,0,1);
			stuDAO.saveStudentCache(st);
//			sqlSession.commit();不论是否提交事务都会导致刷新
			
			stu=stuDAO.getSingleStudent(2);
			System.out.println(stu.getName());
			
	}
	
	
	/**
	 * 二级缓存
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
		[TRACE][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==        Row: 2, 赵日天, 22, 60, 1
		[DEBUG][2018-01-22 11:40:00] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 <==      Total: 1
		赵日天
		赵日天
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 ==> Parameters: 2(Integer)
		[TRACE][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==    Columns: sid, name, age, score, classid
		[TRACE][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 165 <==        Row: 2, 赵日天, 22, 60, 1
		[DEBUG][2018-01-22 11:40:01] Invi.mybatis.DAO.studentDAO.getSingleStudent 159 <==      Total: 1
		赵日天
	*/
		
	}
	
	/**
	 * 二级缓存
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
		
		//增删改会刷新二级缓存,导致重新查询，但命中率是不受影响的
		//原因：清除缓存是对map的value值赋null，而非删除Entry对象
		//所以key还保留着，而hit rate根据key进行计算，所以不受影响
		Student st=new Student(null,"无名氏",1,0,1);
		stuDAO.saveStudentCache(st);
//		sqlSession.commit();不论是否提交事务都会导致刷新
		
		stu=stuDAO.getSingleStudent(2);
		System.out.println(stu.getName());
		
/*		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.0
		[DEBUG]==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG]==> Parameters: 2(Integer)
		[DEBUG]<==      Total: 1
		赵日天
		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.5
		赵日天
		[DEBUG]==>  Preparing: INSERT INTO STUDENT (SID,NAME,AGE,SCORE,ClASSID) VALUES (?,?,?,?,?) 
		[DEBUG]==> Parameters: null, 无名氏(String), 1(Integer), 0(Integer), 1(Integer)
		[DEBUG]<==    Updates: 1
		[DEBUG]Cache Hit Ratio [Invi.mybatis.DAO.studentDAO]: 0.6666666666666666
		[DEBUG]==>  Preparing: SELECT* FROM STUDENT WHERE SID=? 
		[DEBUG]==> Parameters: 2(Integer)
		[DEBUG]<==      Total: 1
		赵日天
*/
	}
}
