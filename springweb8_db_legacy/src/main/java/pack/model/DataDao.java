package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Autowired
	private DataSource dataSource;
	
	public DataDao() {
		
	}
	
	public ArrayList<DataDto> selectAll() {
		ArrayList<DataDto> list = new ArrayList<DataDto>();

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from sangdata"); // 관계형데이터베이스는 SQL문 이외는 접근 불가
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				// rs.next가 false 될때까지 더 추가 가능.
				DataDto dto = new DataDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
}
