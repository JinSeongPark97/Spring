package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pack.controller.FormBean;

@Repository
@Slf4j // 로그 출력 : Lombok지원
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DataMappingInter dataMappingInter;
	
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = dataMappingInter.selectAll();
		//System.out.println("list.size : " + list.size());
		logger.info("list.size : " + list.size());
		return list;
	}
	
	public List<SangpumDto> getDataSearch(FormBean bean){
		List<SangpumDto> slist = dataMappingInter.selectSearch(bean);		
		return slist;	
	}
}