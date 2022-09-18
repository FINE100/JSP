package co.micol.prj.mybatis.mapper;

import java.util.List;

import co.micol.prj.member.service.MemberVO;
<<<<<<< HEAD

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);  //한명, 로그인 체크
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	boolean isIdCheck(String id);  //아이디 중복 체크
=======
//MemberService 와 동일 내용
//서비스 영역과 레퍼지토리 영역에 각각 하나씩

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);		// 한명, 로그인 체크
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	boolean isIdCheck(String id); 			//아이디 중복 체크 


>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
}
