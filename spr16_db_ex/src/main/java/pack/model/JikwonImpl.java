package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter{
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void test() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<JikwonDto> selectList(String gogekNum, String name) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql= "select jikwon_name, jikwon_jik, jikwon_gen"
		+ " from jikwon inner join gogek on jikwon.jikwon_no=gogek.gogek_damsano" 
				+ gogekNum +" and gogek_name" + "'" + name + "'" ;		
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {			
			return new JikwonDto() {
				{ // 내부 무명 클래스
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));	
					setJikwon_gen(rs.getString("jikwon_gen"));	
										
				}
			};
		}
	}
	
}

