package co.micol.prj.member.service;

<<<<<<< HEAD

public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAuthor;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberAuthor() {
		return memberAuthor;
	}
	public void setMemberAuthor(String memberAuthor) {
		this.memberAuthor = memberAuthor;
	}
	
	
}

=======
import lombok.Data;

@Data
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAuthor;

}
>>>>>>> branch 'master' of https://github.com/FINE100/JSP.git
