package net.daum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;
import net.daum.dao.MemberRepository;
import net.daum.dao.ProfileRepository;
import net.daum.vo.MemberVO;
import net.daum.vo.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log // Lombok 라이브러리의 로그 기록을 사용할 때 이용하는 애노테이션
@Commit // 데이터 베이스에 커밋하는 용도로 활용
public class ProfileTests {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired ProfileRepository profileRepo;
	
	// 20명의 회원 자료 추가
	@Test
	public void testInsertMembers() {
		IntStream.range(1, 21).forEach(i->{
			MemberVO mem = new MemberVO();
			
			mem.setUid2("user" + i);
			mem.setUpw("pw" + i);
			mem.setUname("사용자" + i);
			
			this.memberRepo.save(mem); // 20명 회원 저장
		});
	} // testInsertMembers()
	
	@Test
	public void testInsertProfile() {
		MemberVO member = new MemberVO();
		member.setUid2("user1"); // user1 회원 아이디 저장
		
		for(int i=1; i<5; i++) {
			Profile profile01 = new Profile();
			profile01.setFname("face" + i + ".jpg"); // 4개의 프로필 파일명 저장
			
			if(i==1) {
				profile01.setCurrent2(true); // 첫번째 회원 프로필 사진은 현재 사용중인걸로 함
			}
			
			profile01.setMember(member);
			
			// this.profileRepo.save(profile01);
		} // for
	} // testInsertProfile()
	
	// user1 아이디 정보와 프로필 사진 개수 -> Fetch Join
	/*@Test
	public void testFetchJoin01() {
		List<Object[]> result = this.memberRepo.getMemberVOWithProfileCount("user1");
		
		result.forEach(arr -> System.out.println(Arrays.toString(arr)));
		// arr 배열원소값을 문자열로 변환해서 반환
	}*/ // testFetchJoin01
	
	// user1 아이디 정보와 현재 사용중인 프로필 파일정보 => Fetch Join2
	@Test
	public void testFetchJoin() {
		List<Object[]> result = this.memberRepo.getMemberVOWithProfile("user1");
		
		result.forEach(arr -> System.out.println(Arrays.toString(arr)));
	} // testFetchJoin02
	
}
