package io.github.weAreFreedom.member.repository;

import io.github.weAreFreedom.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findById(String id);
}
