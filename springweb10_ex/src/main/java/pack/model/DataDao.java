package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	
	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public List<DataDto> getMemberList(String jik) {
		String sql = "select jikwon_no, jikwon_name, jikwon_gen, jikwon_pay from jikwon where jikwon_jik=?";
		List<DataDto> list = getJdbcTemplate().query(sql, new Object[]{jik}, (ResultSet rs, int rowNum)-> {
			
			DataDto dto = new DataDto();
			dto.setJikwon_no(rs.getString("jikwon_no"));
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setJikwon_gen(rs.getString("jikwon_gen"));
			dto.setJikwon_pay(rs.getString("jikwon_pay"));
			return dto;
		});
		
	
		return list;
	}
}