package org.doorisopen.myspring.Test.Board;

import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.doorisopen.myspring.Board.Service.BoardService;
import org.doorisopen.myspring.common.Pagination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardCRUDTest {
	
	@Autowired
	BoardService service;
	
	Pagination pagination = new Pagination();
	
	
	
	@Test
	public void paginationTest() throws Exception {
		System.out.println("This is paginationTest...");
		
		int listCnt = service.getBoardListCnt();
		System.out.println("listCnt: "+listCnt);
	}
	
	/* TEST 1. 게시글 등록 
	 * 
	 *
	 */
	// Test 가 필요한곳에 아래의 태그 입력한다.
	public void boardCreateTest() {
		System.out.println("This is boardCreateTest...");
		BoardVO vo = new BoardVO();
		
		// Pagination Test를 위한 가상 데이터
		for(int i = 100; i < 150; i++) {
			vo.setBoardTitle("No." + i + " Page Board Test");
			vo.setBoardContent("Hello This is Spring Board Create Test");
			vo.setWriter("admin");
			try {
				service.BoardCreate(vo);
				System.out.println("Success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* TEST 2. 게시글 리스트 
	 * 
	 *
	 */
	public void boardReadTest() {
		System.out.println("This is boardReadTest...");

		try {
			service.BoardRead(pagination);
			System.out.println(service.BoardRead(pagination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* TEST 3. 게시글 수정 
	 * 
	 *
	 */
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
			System.out.println(service.BoardRead(pagination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* TEST 4. 게시글 삭제 
	 * 
	 *
	 */
	public void boardDeleteTest() {
		System.out.println("This is boardDeleteTest...");
		BoardVO vo = new BoardVO();
		
		int boardIdx = 2;
		
		try {
			service.BoardDelete(boardIdx);
			System.out.println(service.BoardRead(pagination));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
