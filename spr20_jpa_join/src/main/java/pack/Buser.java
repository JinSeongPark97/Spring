package pack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="buser")
public class Buser {
	@Id
	@Column(name="buser_no") // 물리적 칼럼명.
	private int buserNo;
	
	@Column(name="buser_name") // 물리적 칼럼명.
	private String buserName;
}
