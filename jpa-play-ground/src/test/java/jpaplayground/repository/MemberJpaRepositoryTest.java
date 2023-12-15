package jpaplayground.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jpaplayground.SpringDataJpa.entity.Member;
import jpaplayground.SpringDataJpa.repository.MemberJpaRepository;

@Transactional
@SpringBootTest
@Rollback(value = false)
class MemberJpaRepositoryTest {

	@Autowired
	MemberJpaRepository memberJpaRepository;

	@DisplayName("")
	@Test
	void testMember() {
		// given
		Member member = new Member("memberA");
		// when
		Member savedMember = memberJpaRepository.save(member);
		Member findMember = memberJpaRepository.find(savedMember.getId());
		// then
		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		assertThat(findMember).isEqualTo(member);
	}
}
