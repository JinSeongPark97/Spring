package pack;

// 핵심 로직 : target에 해당
public class LogicImpl implements LogicInter{
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll(); // 모델 클래스 수행 결과
		
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("-------------");
		System.out.println("selectDataProcess2 처리");
		articleInter.selectAll(); // 모델 클래스 수행 결과
		
		try {
			Thread.sleep(3000); // 3초
			
		} catch (Exception e) {
			System.out.println("selectDataProcess2 err : " + e);
		}
		System.out.println("3초 지연 처리");
	}
}
