package pack;

import org.springframework.data.repository.CrudRepository;
//엔티티클래스 : ProductVo
public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer> {
	// save(), findById(), count(), 지원 받음
	

}
