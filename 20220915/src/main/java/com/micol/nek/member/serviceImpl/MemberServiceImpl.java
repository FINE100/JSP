package com.micol.nek.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.micol.nek.common.DataSource;
import com.micol.nek.member.service.MemberService;
import com.micol.nek.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = new DataSource(); // 데이터 연결 객체 생성
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체 멤버 목록 가져오기
		List<MemberVO> list = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER";
		try {
			psmt = dao.conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) { // 한 행씩 읽어달라, 여러 행 부를땐 while
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // connection 끊어준다.
		}
		return list;

	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 한명의 멤버를 조회한다.
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";

		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId()); // sql문 ? 써준 순서대로 작성.
			rs = psmt.executeQuery(); 			// 결과 set

			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 한 명의 데이터 추가
		int r = 0;
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?)";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAuthor());

			r = psmt.executeUpdate(); // 성공하면 1, 실패하면0
			
			if(r ==1) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패, 재확인 요망");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return r;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 한명의 데이터 변경, 아이디를 제외한 모든 값이 변경 가능함
		int r = 0 ;
		String sql = "UPDATE MEMBER SET MEMBER_PASSWORD =?, MEMBER_NAME =?, MEMBER_TEL=?, MEMBER_AUTHOR=? WHERE MEMBER_ID=?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberTel());
			psmt.setString(4, vo.getMemberAuthor());
			psmt.setString(5, vo.getMemberId());
			
			r= psmt.executeUpdate();
			
			if(r ==1) {
				System.out.println("변경 성공");
			}else {
				System.out.println("변경 실패, 재확인 요망");
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return r;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		//멤버삭제
		int r =0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID=?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1,vo.getMemberId());
			r = psmt.executeUpdate();
			
			if(r ==1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패, 재확인 요망");
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}

	@Override
	public boolean isMemberId(String id) {
		// 아이디 중복체크
		boolean b= false;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID=?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(!rs.next()) { //존재하면 false 이므로 ! 붙여줌, 한 행 검색 시 if 
				b = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return b;
	}

	private void close() { // DBMS 와 연결을 끊어준다

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (dao.conn != null)
				dao.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
