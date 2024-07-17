package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport { // 상속
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource); // DB연결정보 입력.
	}
	
	
	// 전체 자료 읽기
	public List<MemberDto> getMemberList() {
		String sql = "select * from memberteb";
		/*
		// 내부 무명 클래스
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
			});
		*/
		// 람다 표현식 사용
		List<MemberDto> list = getJdbcTemplate().query(sql,(ResultSet rs, int rowNum) -> {
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
		return list;
	}
	
	// 자료 추가
	public void insData(MemberBean bean) {
		String sql = "insert into memberteb values(?,?,?,now())"; // 시큐어코딩 중요.
		// insert는 update 메소드 사용.
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()}; // bean을 직접 사용이 아닌 Object 객체로 변환해서 삽입해야함.
		getJdbcTemplate().update(sql, params);
	}
	
	// 특정 레코드 읽기
	public MemberDto getMember(String id) {
		String sql = "select * from memberteb where id=?";
		MemberDto dto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setReg_date(rs.getString("reg_date"));
				return dto;
			}
		});
		return dto;
	}
	
	// 자료 수정
	public void upData(MemberBean bean) {
		String sql = "update memberteb set name=?, passwd=? where id=?";
		getJdbcTemplate().update(sql,new Object[] {bean.getName(),bean.getPasswd(),bean.getId()});
	}
	
	// 자료 삭제
	public void delData(String id) {
		String sql = "delete from memberteb where id=?";
		getJdbcTemplate().update(sql,new Object[] {id});
	}
}