package org.doorisopen.myspring.Member.Service;

import java.util.List;

import org.doorisopen.myspring.Member.Domain.MemberVO;
import org.doorisopen.myspring.Member.Persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(MemberVO vo) throws Exception {
		memberDAO.add(vo);
	}
	
	public List<MemberVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}
	
}
