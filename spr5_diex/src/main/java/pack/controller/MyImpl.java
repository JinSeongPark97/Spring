package pack.controller;

import java.util.Scanner;

import pack.model.SangpumImpl;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter; // SangpumInter 타입의 멤버필드 inter
	private String rs[];
	
	public void setInter(SangpumInter inter) { 	// 멤버 메서드
		this.inter = inter;
	}

	@Override
	public void inputData() {
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("상품 입력 : ");
			String sang = scanner.next();
			System.out.println("수량 입력 : ");
			int su = scanner.nextInt();
			System.out.println("단가 입력 : ");
			int dan = scanner.nextInt();
			rs = inter.calcMoney(sang, su, dan);
			 
			
		} catch (Exception e) {
			System.out.println("inputData err : "  + e.getMessage());
		}
	}
	
	@Override
	public void showData() {
	System.out.println("상품명: " + rs[0] + "\n" + "금액은: " +  rs[1] + "원");
		
	}
}
