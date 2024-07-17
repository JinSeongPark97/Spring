package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface DataMappingInter {
	
	// 전체 자료 읽기
	@Select("select * from jikwon")
	List<JikwonDto> selectAll();
	
	@Select("select jikwon_no,jikwon_name,jikwon_gen,jikwon_pay from jikwon where jikwon_jik = #{jik}")
	List<JikwonDto> selectSearch(String jik); // 검색 
}
