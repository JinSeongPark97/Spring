package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	@Autowired
	private JikwonRepositoty repo;
	
	//특정 자료 읽기
	public List<Jikwon> getSearchValue(String jik){
		List<Jikwon> list = repo.findByJik(jik);
		return list;
	}
}
