package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Springweb14JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springweb14JpaApplication.class, args)
		.getBean(Springweb14JpaApplication.class).execute();
	}
	
	@Autowired
	ProductCrudRepository repository;
	
	private void execute() {
		System.out.println("execute");
		
		//insertData(); // 추가
		selectData();
	}
	
	// 추가 및 수정 : 등록된 숫자가 중복되어 추가하면 자동으로 수정
	private void insertData() {
		/*
		ProductVo productVo = new ProductVo();
		productVo.setSang("만능볼펜");
		productVo.setSu(3);
		productVo.setDan(3500);
		productVo = repository.save(productVo);  // save : 추가 데이터 저장
		System.out.println("등록 데이터 : " + productVo);
		*/
		ProductVo productVo = new ProductVo();
		productVo.setCode(1);
		productVo.setSang("지우개");
		productVo.setSu(3);
		productVo.setDan(2500);
		productVo = repository.save(productVo);  // save : 추가 데이터 저장
		System.out.println("등록 데이터 : " + productVo);
	}
	
	// 전체 자료 조회
	private void selectData() {
		System.out.println("전체 자료 읽기 : DBMS에 독립적이다.");
		List<ProductVo> list = repository.findAll();
		
		for(ProductVo vo:list) {
			System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());			
		}
		System.out.println("부분 자료 읽기");
		ProductVo vo = repository.findById(1).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println();
		ProductVo vo3 = repository.findByCode(2); // findByCode() : 규칙에 따라 만든 메소드
		System.out.println(vo3.getCode() + " " + vo3.getSang() + " " + vo3.getSu() + " " + vo3.getDan());
		
		System.out.println("-------JPQL 사용---------");
		List<ProductVo> list2 = repository.findAllData(); // findAllData() 메소드는 직접 만든 메소드
		for(ProductVo vo2 : list2) {
			System.out.println(vo2.getCode() + " " + vo2.getSang() + " " + vo2.getSu() + " " + vo2.getDan());
		}
		
		System.out.println("부분 자료 읽기 - JPQL");
		ProductVo vo4 = repository.findByCodeMy(1); // 메소드 이름 임의 생성(이름 기반)
		System.out.println(vo4.getCode() + " " + vo4.getSang() + " " + vo4.getSu() + " " + vo4.getDan());
		
		ProductVo vo5 = repository.findByCodeMy2(1); // 메소드 이름 임의 생성(순서(위치) 기반)
		System.out.println(vo5.getCode() + " " + vo5.getSang() + " " + vo5.getSu() + " " + vo5.getDan());
		
		List<ProductVo> list3 = repository.findByData(1,"물티슈"); // 
		for(ProductVo vo6 : list3) {
			System.out.println(vo6.getCode() + " " + vo6.getSang() + " " + vo6.getSu() + " " + vo6.getDan());
		} 
	}

}
