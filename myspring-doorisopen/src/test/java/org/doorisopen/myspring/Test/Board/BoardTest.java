package org.doorisopen.myspring.Test.Board;

import org.doorisopen.myspring.urlControllerTest;
import org.doorisopen.myspring.Board.Domain.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardTest {
	
	private static final Logger logger = LoggerFactory.getLogger(urlControllerTest.class);
	
	// GET, POST URL TEST
	// GET Test
	// http://localhost:8080/myspring/BoardPage
	@RequestMapping(value="/BoardPage", method = RequestMethod.GET)
	public String BoardCreatePage() {

		logger.info(" /BoardPage URL GET method called. then BoardCreatePage method executed.");
		return "/urlControllerTest/BoardCreate";
	}
	
	// POST Test
	// http://localhost:8080/myspring/BoardCreate
	@RequestMapping(value="/BoardCreate", method = RequestMethod.POST)
	public String BoardCreate(@ModelAttribute("board") BoardVO vo) {
		logger.info(vo.toString());
		logger.info(" /BoardCreate URL POST method called. then BoardCreate method executed.");
		return "/urlControllerTest/BoardResult";
	}
	
	
	
}
