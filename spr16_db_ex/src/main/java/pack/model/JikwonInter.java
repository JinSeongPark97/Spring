package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface JikwonInter {
	List<JikwonDto> selectList(String gogekNum, String name) throws DataAccessException;
}
