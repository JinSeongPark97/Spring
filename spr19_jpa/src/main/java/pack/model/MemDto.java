package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder // Builder 어노테이션의 경우에는 매개변수가 있는 생성자를 선언해야함.
@NoArgsConstructor // 꼭 있어야함. 
@AllArgsConstructor

// 하이버네이트 : JPA
@Entity(name="mem") // DB의 특정 테이블과 매핑
public class MemDto { // 카멜케이스로 작성하면 자동으로 JPA에서 언더스코어 네이밍 컨벤션을 따른다. 
	@Id
	@Column(name="num")
	private int num; // num : Pk이므로 위와 같이 적어줌 (@id)
	
	@Column(name="name", nullable = true) // flase : not null
	// 스트링 하나하나 추가해서 해야 에러 x
	private String name;
	private String addr;
}
