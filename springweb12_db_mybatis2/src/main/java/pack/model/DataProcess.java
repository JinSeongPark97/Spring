package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInter dataMapperInter; // HikariPool 자동 지원
	
	// 전체 자료 읽기
	// 복수일 경우 ArrayList가 아닌 list 사용.
	public List<MemDto> getDataAll() { 
		List<MemDto> list = dataMapperInter.selectAll();
		logger.info("전체 자료 크기 : " + list.size()); // System.out과 동일(출력)
		return list;
	}
	
	// 부분 자료 읽기 - 하나만 읽을 경우에는 list 사용 x
	public MemDto getData(String num) { // pk : num
		MemDto dto = dataMapperInter.selectPart(num);
		return dto;
		
	}
	
	// 추가
	public boolean insert(MemBean bean) { 		// insert는 0과 1
		// 번호 중복 방지 또는 번호 자동 증가 작업 필요하나 생략.
		int result = dataMapperInter.insertData(bean);
		if(result > 0)
			return true;
		else
			return false;		
	}
	
	// 수정
	public boolean update(MemBean bean) { 		// insert는 0과 1
		// 번호 중복 방지 또는 번호 자동 증가 작업 필요하나 생략.
		int result = dataMapperInter.updateData(bean);
		if(result > 0)
			return true;
		else
			return false;		
	}
	
	// 삭제
	public boolean delete(String num) { 		// insert는 0과 1
		// 번호 중복 방지 또는 번호 자동 증가 작업 필요하나 생략.
		int result = dataMapperInter.deleteData(num);
		if(result > 0)
			return true;
		else
			return false;		
	}
}
