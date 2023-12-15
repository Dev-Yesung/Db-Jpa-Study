package jpaplayground.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jpaplayground.SpringDataJpa.entity.Member;
import jpaplayground.SpringDataJpa.repository.MemberRepository;

@Rollback(value = false)
@Transactional
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@DisplayName("")
	@Test
	void testMember() {
		Member member = new Member("memberA");

		Member savedMember = memberRepository.save(member);
		Member findMember = memberRepository.findById(savedMember.getId())
			.orElseThrow(RuntimeException::new);

		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		assertThat(findMember).isEqualTo(member);
	}
}
