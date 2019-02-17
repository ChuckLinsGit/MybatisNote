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
	
	private  SqlSessionFactory sqlSessionFactory;
	
	public MybatisUtil() {
		
		InputStream in;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}//读取主配置文件
	}



	public SqlSession getSqlSession(){
		//二级缓存必须保证使用的sqlSession是在同一个sqlSessionFactory下的sqlsession
			return sqlSessionFactory.openSession();
	}
}
