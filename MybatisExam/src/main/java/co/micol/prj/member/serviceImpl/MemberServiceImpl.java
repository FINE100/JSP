package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.map.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSessionFactory sqlSessionFactory = DataSource.sqlSession();
	private MemberMapper map = sqlSessionFactory.openSession(true).getMapper(MemberMapper.class); //MemberMapper.xml 가져오라
	

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
	public boolean isMemberId(String id) {		
		return map.isMemberId(id);
	}

}
