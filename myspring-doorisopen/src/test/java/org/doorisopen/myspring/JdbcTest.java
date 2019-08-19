package org.doorisopen.myspring;

import java.util.List;

import org.doorisopen.myspring.Member.Domain.MemberVO;
import org.doorisopen.myspring.Member.Service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Hello DB-SPRINGJDBC");
		ctx = new ClassPathXmlApplicationContext("Testcontext.xml");
		MemberService memberService = (MemberService)ctx.getBean(MemberService.class); // by Class name
		
		String strID = "Anonymous";
		MemberVO vo = new MemberVO();
		
		vo.setId(strID); 
		vo.setPasswd(strID); 
		vo.setUsername(strID); 
		vo.setSnum(strID);
		
		try {
			// memberService.addMember(vo);
			MemberVO member = memberService.readMember(strID);
			System.out.println(member);
			List<MemberVO> list = memberService.readMemberList();
			for(MemberVO svo : list) {
					System.out.println(svo);
			}
			
		} catch(DataAccessException e) {
			System.out.println(e);
			
		} finally { //Check Count
			JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
			int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENT", Integer.class);
			System.out.println(count);
		}
	}

	
}
