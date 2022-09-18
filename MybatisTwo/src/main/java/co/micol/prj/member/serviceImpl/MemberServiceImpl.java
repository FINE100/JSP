package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.mybatis.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService {
<<<<<<< HEAD
	//Mybatis Mapper를 연결한다.
	private SqlSession sqlSession = DataSource.getSession().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		System.out.println("imple" + id);
		return map.isIdCheck(id);
	}

//	@Override
//	public boolean isMemberId(String id) {
//		// TODO Auto-generated method stub
//		return false;
	}


=======
	private SqlSession sqlSession = DataSource.getSession().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class); 
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		
		return map.memberDelete(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		
		return map.isIdCheck(id);
	}

}
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
