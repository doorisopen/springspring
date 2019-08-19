package org.doorisopen.myspring.Member.Service;

import java.util.List;

import org.doorisopen.myspring.Member.Domain.MemberVO;

public interface MemberService {
	
	public MemberVO readMember(String id) throws Exception;
	public void addMember(MemberVO vo) throws Exception;
	public List<MemberVO> readMemberList() throws Exception;
	
}
