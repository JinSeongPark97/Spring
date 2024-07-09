package anno2_resource;

import org.springframework.stereotype.Component;

@Component
public class Abc1 {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
