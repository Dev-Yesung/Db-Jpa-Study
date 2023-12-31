package jpaplayground.SpringDataJpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpaplayground.SpringDataJpa.entity.Member;

@Repository
public class MemberJpaRepository {

	@PersistenceContext
	private EntityManager em;

	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	public void delete(Member member) {
		em.remove(member);
	}

	public List<Member> findAll() {
		return em.createQuery("SELECT m FROM Member m", Member.class)
			.getResultList();
	}

	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	public long count() {
		return em.createQuery("SELECT COUNT(m) FROM Member m", Long.class)
			.getSingleResult();
	}

	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}
