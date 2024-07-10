package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	// 직원별
	@Override
	public List<JikwonDto> JikwonList() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;

		try {
			SqlMapperInter mapperInter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectdataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close(); 
		}
		
		return list;
	}	
	
	// 부서별
	@Override
	public int BuserList(String buserNum) {
		 SqlSession sqlSession = factory.openSession();
	        int count = 0;

	        try {
	            SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);
	            count = mapper.buserCount(buserNum);
	        } catch (Exception e) {
	            System.out.println("getBuserCount error : " + e);
	        } finally {
	            if(sqlSession != null) sqlSession.close();
	        }

	        return count;
	    }
	
	// 페이별
	@Override
	public JikwonDto PayList(String buserNum) {
		 SqlSession sqlSession = factory.openSession();
	        JikwonDto highestPaid = null;

	        try {
	            SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);
	            highestPaid = mapper.buserPay(buserNum);
	        } catch (Exception e) {
	            System.out.println("getHighestPay error : " + e);
	        } finally {
	            if(sqlSession != null) sqlSession.close();
	        }

	        return highestPaid;
	    }
	}