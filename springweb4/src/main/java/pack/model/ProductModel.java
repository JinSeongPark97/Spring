package pack.model;

import org.springframework.stereotype.Service;

import pack.controller.ProductBean;

@Service
public class ProductModel {
	public String computerPrice(ProductBean bean) {
		String data = "품명: " + bean.getSang() + " " +
				", 금액: " + (bean.getSu() * bean.getDan());
		 
		return data;
	}
	
}
