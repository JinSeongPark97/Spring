package pack.model;

import java.util.List;

public interface JikwonInter {

	List<JikwonDto> JikwonList(); // 추상
	
	List<JikwonDto> BuserList(String buserNum);
	
	List<JikwonDto> PayList(String buserNum);
}
