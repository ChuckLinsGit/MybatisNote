package utils;

import java.io.IOException;	
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.io.Resources;


public class MybatisUtil {

	private SqlSession sqlSession;
	
	public SqlSession getSqlSession(){
		
		try {
			InputStream in=Resources.getResourceAsStream("mybatis-config.xml");//读取主配置文件
			
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
			return sqlSessionFactory.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
