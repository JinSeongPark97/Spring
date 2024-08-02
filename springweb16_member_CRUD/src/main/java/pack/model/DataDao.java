package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private MemberRepo memberRepo;
	
	// 전체 자료 읽기
	public List<Mem> getDataAll() {
		List<Mem> list = memberRepo.findAll();
		return list;
	}
	
	// 추가
	
	// 수정
	
	// 삭제
	
}
