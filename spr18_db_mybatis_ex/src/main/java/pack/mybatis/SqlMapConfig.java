package pack.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.model.SqlMapperInter;

public class SqlMapConfig {
	 public static SqlSessionFactory sqlSessionFactory;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
	 
	  static{
	     String resource = "pack/mybatis/Configuration.xml"; // XML파일 읽기
	     try {
	         Reader reader = Resources.getResourceAsReader(resource); // configuration.xml을 읽음
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // 객체 생성
	         reader.close();
	         
	         
	         // MyBatis Annotation 사용시 추가
	         Class[] mappers = { SqlMapperInter.class }; // 인터페이스가 여러개일수도있으니 배열로 처리 , factory에 등록함
	         for(Class cl : mappers) {
	        	 sqlSessionFactory.getConfiguration().addMapper(cl);
	         }
	     } catch (Exception e) {
	     System.out.println("SqlMapConfig 오류 : " + e);
	  }
	}
	 
	public static SqlSessionFactory getSqlSession(){  
	     return sqlSessionFactory;
	  }
	}