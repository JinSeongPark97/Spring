package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemBean;

@Mapper // 마커 인터페이스
public interface DataMapperInter {
	
	// 전체 조회
	@Select("select * from mem")
	List<MemDto> selectAll();
	
	// 특정 조회
	@Select("select * from mem where num=#{num}")
	MemDto selectPart(String num);
	
	// 추가
	@Insert("insert into mem values(#{num},#{name},#{addr})")
	int insertData(MemBean bean);
	
	// 수정
	@Update("update mem set name=#{name},addr=#{addr} where num=#{num}")
	int updateData(MemBean bean);
	
	// 삭제
	@Delete("delete from mem where num=#{num}")
	int deleteData(String num);
	
}
