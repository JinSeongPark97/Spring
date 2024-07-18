package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import aaa.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"aaa"})

public class Springweb13JpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springweb13JpaBasicApplication.class, args)
		.getBean(Springweb13JpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass class1; 
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		//insData(); // 추가 및 수정
		delData(); // 삭제
		selectData(); // 목록보기
		class1.abc();
	}
	
	private void delData() {
		crudRepository.deleteById(5); 
	}
	
	private void insData() {
		ProductVo productVo = new ProductVo(null, "보드마카", 2, 1500);		
		System.out.println(productVo.toString());
		crudRepository.save(productVo);
	}
	
	private void selectData() {
		// findAll() : 전체 자료 읽기 -> 내부적으로 SQL문을 실행.
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		//System.out.println(list.get(0).getSang());
		for(ProductVo p:list) {
			System.out.println(p.getCode() + " " + 
					p.getSang() + " " +
					p.getSu() + " " +
					p.getDan());
		}
		System.out.println("---------------");
		// 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode() + " " + 
					vo.getSang() + " " +
					vo.getSu() + " " +
					vo.getDan());
	}

}
