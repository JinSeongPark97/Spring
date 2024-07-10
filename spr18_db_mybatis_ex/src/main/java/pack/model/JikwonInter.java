package pack.model;

import java.util.List;

public interface JikwonInter {

	List<JikwonDto> JikwonList(); // 추상
	int BuserList(String buserNum);
	JikwonDto PayList(String buserNum);
}
