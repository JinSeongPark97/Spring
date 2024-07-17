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
public class JikwonDao {
	@Autowired
	private DataMappingInter dataMappingInter;
	
	public List<JikwonDto> getDataAll() {
		List<JikwonDto> list = dataMappingInter.selectAll();
		return list;
	}
	
	public List<JikwonDto> getDataSearch(String jik){
		List<JikwonDto> slist = dataMappingInter.selectSearch(jik);
		return slist;
	}
}