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
		}//��ȡ�������ļ�
	}



	public SqlSession getSqlSession(){
		//����������뱣֤ʹ�õ�sqlSession����ͬһ��sqlSessionFactory�µ�sqlsession
			return sqlSessionFactory.openSession();
	}
}
