package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); // 엔티티의 생명주기를 관리. CRUD 수행		
		EntityTransaction tx = em.getTransaction(); // 트랜잭션을 관리하는 인터페이스
		
		List<MemDto> list = null;
		
		try {
			// 레코드 추가
			/*
			tx.begin();
			MemDto dto1 = new MemDto();
			dto1.setNum(4); // 
			dto1.setName("이순신");
			dto1.setAddr("서초구 방배동");
			em.persist(dto1);
			// Hibernate : insert pack.model.MemDto
			// 실제 SQL 처리 : inset into mem (addr, name, num) values (?, ?, ?)
			tx.commit();
			*/
			
			// 레코드 수정 : Setter 활용하여 수정하면 됨
			/*
			tx.begin();
			MemDto dto2 = em.find(MemDto.class, 4);
			dto2.setName("조조");
			tx.commit();
			// Hibernate: select memdto0_.num as num1_0_0_, memdto0_.addr as addr2_0_0_, memdto0_.name as name3_0_0_ from mem memdto0_ where memdto0_.num=?
			// Hibernate: update pack.model.MemDto
			// update mem set addr=?, name=? where num=?
			*/
			
			// 레코드 삭제
			tx.begin();
			MemDto dto3 = em.find(MemDto.class, 4);
			em.remove(dto3);
			tx.commit();
			
			
			System.out.println("부분 자료 읽기(단일 엔티티) find() 메소드 사용");
			// public find(Class<T> entityClass, Object pk)
			MemDto mdto = em.find(MemDto.class, 2); // 2번 자료를 확인 할수 있다.
			System.out.println(mdto.getNum() + " " +
							mdto.getName() + " " +
							mdto.getAddr());
			
			System.out.println("부분 자료 읽기(복수 엔티티) like ");
			List<MemDto> listPart = findByAddr(em,"강남");
			
			for(MemDto m : listPart) {
				System.out.println(m.getNum() + " " +
						m.getName() + " " +
						m.getAddr());
			}
			
			System.out.println("---- 전체 자료 읽기 ----");			
			/*
			list = findAll(em, MemDto.class);
			for(MemDto m : list) {
				System.out.println(m.getNum() + " " +
						m.getName() + " " +
						m.getAddr());
			}
			*/
			
			list = em.createQuery("select e from MemDto as e",MemDto.class).getResultList();
			// Hibernate : ==> select e from MemDto e --> RDBMS 종류에 관계없이 공통적으로 사용.
			// Hibernate가 DBDialect를 보고 실제 SQL문으로 변환 -->
			// select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : " + e);
		}finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em, String ss) {
		// addr 필드가 특정 접두사로 시작되는 레코드 읽기
		String jpql = "SELECT m FROM MemDto m WHERE m.addr LIKE : ss";
		
		TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
		// TypedQuery<entity> query = em.createQuery(jpql, entity클래스)
		// JPQL을 작성하고 실행하는 역할
		query.setParameter("ss", ss + "%");
		return query.getResultList();
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) {
		// JPQL
		// cla.getName() : pack.model.DataDto
		// cla.getSimpleName() : DataDto
		System.out.println(cla.getSimpleName());
		return em.createQuery("select e from " + cla.getSimpleName() + " e",cla).getResultList(); // 테이블에 대한 별명 "e"	 
	}
}