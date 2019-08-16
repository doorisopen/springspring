package org.doorisopen.myspring;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardTest {
	
	private static ApplicationContext ac = null;
	public static void main(String[] args) throws Exception {
		System.out.println("Hello DI - XML");
		
		ac = new GenericXmlApplicationContext("Testcontext.xml");
		/* Method 1. annotation-config
		BoardService service = (BoardService)ac.getBean("boardService"); // by Component name
		*/
		// Method 2. context:component-scan
		BoardService service = (BoardService)ac.getBean(BoardService.class); // by Class name
		
		BoardVO vo = new BoardVO();
		vo.setBoardTitle("두 번째 게시글 테스트");
		
		service.BoardWrite(vo);
		
		vo = service.BoardDetail("두 번째 게시글 테스트");
		System.out.println(vo);
	}
}










