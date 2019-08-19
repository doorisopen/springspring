package org.doorisopen.myspring.Member.Persistence;

import java.util.List;

import org.doorisopen.myspring.Member.Domain.MemberVO;

public interface MemberDAO {
	
	public void add(MemberVO vo) throws Exception;
	public MemberVO read(String id) throws Exception;
	public List<MemberVO> readList() throws Exception;

}
