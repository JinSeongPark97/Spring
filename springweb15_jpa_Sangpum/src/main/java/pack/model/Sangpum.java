package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sangdata")
public class Sangpum {
	@Id // PK 이기때문에 적용
	private int code;
	@Column(nullable = false) // Null 허용 x
	private String sang;
	@Column(nullable = false)
	private int su;
	@Column(nullable = false)
	private int dan;
}
