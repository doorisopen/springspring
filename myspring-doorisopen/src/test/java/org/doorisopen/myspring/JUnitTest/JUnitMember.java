package org.doorisopen.myspring.JUnitTest;

import org.doorisopen.myspring.Member.Domain.MemberVO;
import org.doorisopen.myspring.Member.Service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/Testcontext.xml")
public class JUnitMember {
	
	
	@Autowired
	MemberService memberService;
	
	@Test
	public void testReadMember( ) throws Exception {
		MemberVO member = memberService.readMember("Anonymous");
		System.out.println(member);
	}
}
