package org.doorisopen.myspring.Test.Board;

import org.doorisopen.myspring.Board.Controller.BoardController;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardCRUDTest {
	
	@Autowired
	BoardService service;
	
	// Test 가 필요한곳에 아래의 태그 입력한다.
	
	public void boardCreateTest() {
		System.out.println("This is boardCreateTest...");
		BoardVO vo = new BoardVO();
		
		vo.setBoardTitle("First Board Test");
		vo.setBoardContent("Hello This is Spring Board Create Test");
		vo.setWriter("leetaewoong");
		
		try {
			service.BoardCreate(vo);
			System.out.println("Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void boardReadTest() {
		System.out.println("This is boardReadTest...");
		BoardVO vo = new BoardVO();
		
		try {
			service.BoardRead(vo);
			System.out.println(service.BoardRead(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void boardUpdateTest() {
		System.out.println("This is boardUpdateTest...");
		BoardVO vo = new BoardVO();
		
		int boardIdx = 2;
		vo.setBoardIdx(boardIdx);
		vo.setBoardTitle("Board Update Test");
		vo.setBoardContent("Goodbye This is Spring Board Update Test");
		vo.setModifier("admin");
		
		try {
			service.BoardUpdate(vo);
			System.out.println(service.BoardRead(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void boardDeleteTest() {
		System.out.println("This is boardDeleteTest...");
		BoardVO vo = new BoardVO();
		
		int boardIdx = 2;
		
		try {
			service.BoardDelete(boardIdx);
			System.out.println(service.BoardRead(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
