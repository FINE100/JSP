package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

<<<<<<< HEAD
public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {};
	
	public static SqlSessionFactory getSession() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource); // conn(); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
=======
public class DataSource { // DAO
	private static SqlSessionFactory sqlSessionFactory;

	private DataSource() {}

	public static <sqlSessionFactory> SqlSessionFactory getSession() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return sqlSessionFactory;
	}

}
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
