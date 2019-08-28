package org.doorisopen.myspring.Test.Member;

import java.nio.charset.Charset;

import org.doorisopen.myspring.urlControllerTest;
import org.doorisopen.myspring.Member.Domain.MemberVO;
import org.doorisopen.myspring.Member.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/member/rest")
public class MemberRestTest {
	
	
private static final Logger logger = LoggerFactory.getLogger(urlControllerTest.class);
	
	@Autowired(required=true)
	private MemberService service;
	
	// Json GET
	@RequestMapping(value="/json/{id}", method = RequestMethod.GET)
	public ResponseEntity<MemberVO> MemberReadJson(@PathVariable String id) throws Exception {
		
		MemberVO vo = service.readMember(id);
		logger.info(" /member/rest/json/{id} REST-API GET method called. then method executed.");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");

		return new ResponseEntity<MemberVO>(vo, headers, HttpStatus.OK);
	}
	
	// XXXXXXXXXXXXXXXXXXX 기능수행 실패 XXXXXXXXXXXXXXXXXXX
	// Xml GET
	// 
	@RequestMapping(value="/xml/{id}", method = RequestMethod.GET)
	public ResponseEntity<MemberVO> MemberReadXml(@PathVariable String id) throws Exception {
		
		MemberVO vo = service.readMember(id);
		logger.info(" /member/rest/xml/{id} REST-API GET method called. then method executed.");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "xml", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		return new ResponseEntity<MemberVO>(vo, headers, HttpStatus.OK);
	}
	
	// Xml Post
	@RequestMapping(method = RequestMethod.POST)
	public String createMemberPost( @RequestBody MemberVO vo) throws Exception {
		service.addMember(vo);
		logger.info(vo.toString());
		logger.info(" /member/rest/{id} REST-API POST method called. then method executed.");
		return "OK";
	}
	
	
}
