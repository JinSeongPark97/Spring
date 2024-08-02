package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository가 사용하는 메소드 사용
public interface SangpumRepository extends JpaRepository<Sangpum, Integer> { 
	// 검색
	// 메소드 네이밍 룰 : findBy[앤티티명]칼럼명..., readBy[앤티티명]칼럼명..., getBy[앤티티명]칼럼명...
	// findBy변수명And변수명, findBy변수명Or변수명, findBy변수명 GreaterThanEqual... 등,
	
	List<Sangpum> findBySangContaining(String svalue); // 검색어가 포함된 : like '%검색어%'
	List<Sangpum> findBySangStartingWith(String svalue); // 검색어로 시작되는 : like '검색어%'
	List<Sangpum> findBySangEndingWith(String svalue); // 검색어로 끝나는 : like '%검색어'
	
	// JPQL 사용
	@Query(value = "select s from Sangpum as s where s.sang like %:svalue%") // 이름에 의한 매핑
	List<Sangpum> searchLike(@Param("svalue") String svalue);
}
