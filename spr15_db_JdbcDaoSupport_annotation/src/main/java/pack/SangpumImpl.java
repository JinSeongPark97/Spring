package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	
	@Autowired // type에 의한 매핑
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rowMapper = new SangpumRowMapper();
		// JdbcDaoSupport 추상 클래스는 getJdbcTemplate() 메소드를 가지고 있다.
		// getJdbcTemplate() 메소드는 query() 메소드를 가지고 있다.
		
		return (ArrayList)getJdbcTemplate().query("select * from sangdata", rowMapper); // 이녀석을 써야 SQL 쿼리문 사용가능 , rs, pstmt 사용 안해도됨.
	}
	
	// 내부 클래스 → 밖에서도 선언 가능.
	class SangpumRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 내부적으로 수행되는 PreparedStatment에 의해 select의 실행 결과가 mapRow로 전달됨. rs.next() 사용 x
			// System.out.println("rowNum : " + rowNum);
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto; // Object으로 반환되므로 23행에서 casting 함.
			// rowMapper에 의해 dto가 List 컬렉션에 저장. 레코드 자료가 소진될 때 까지.
		}
	}
}
