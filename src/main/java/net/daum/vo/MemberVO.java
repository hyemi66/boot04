package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity //엔티티빈 클래스 =>JPA
@Table(name="tbl_members") //tbl_members테이블 생성
@EqualsAndHashCode(of="uid2")
/* equals(),hashCode(),canEqual()메서드 자동생성 
 */
public class MemberVO {//회원 엔티티빈

	@Id //엔티티 빈을 식별할 있도록 해주는 식별키(구분키) -> 유일한 회원아이디(기본키)
	private String uid2; //회원아이디
	private String upw; //비밀번호
	private String uname; //회원이름
}
