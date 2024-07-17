package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Autowired
	private DataSource ds;
	
	public DataDao() {
		
	}
	
	public ArrayList<DataDto> selectAll(String jik) {
		ArrayList<DataDto> list = new ArrayList<DataDto>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select jikwon_no, jikwon_name, jikwon_gen, jikwon_pay from jikwon where jikwon_jik=?"); // 관계형데이터베이스는 SQL문 이외는 접근 불가
			pstmt.setString(1, jik);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				// rs.next가 false 될때까지 더 추가 가능.
				DataDto dto = new DataDto();
				dto.setJikwon_no(rs.getString("jikwon_no"));
				dto.setJikwon_name(rs.getString("jikwon_name"));
				dto.setJikwon_gen(rs.getString("jikwon_gen"));
				dto.setJikwon_pay(rs.getString("jikwon_pay"));
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
	
	public int countJikwon(String jik) {
		int cnt = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select count(*) as cnt from jikwon where jikwon_jik=?"); // 관계형데이터베이스는 SQL문 이외는 접근 불가
			pstmt.setString(1, jik);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("countJikwon err : " + e);
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
		return cnt; 
	}
}
