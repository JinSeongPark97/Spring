package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	// JdbcDaoSupport : dataSource, jdbcTemplate <== getter, setter 있다.
	@Autowired
	 public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);			
	}
	
	
	public List<DataDto> getDataAll() {
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper()); 
	}
	
	class ItemRowMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DataDto dto = new DataDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}
