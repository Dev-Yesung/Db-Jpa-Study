package jpaplayground.SpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpaplayground.SpringDataJpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
