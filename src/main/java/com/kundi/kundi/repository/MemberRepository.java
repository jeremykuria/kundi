package com.kundi.kundi.repository;

import org.springframework.data.repository.CrudRepository;

import com.kundi.kundi.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findByGroupId(Integer id);
    Optional<Member> findByEmailIgnoreCase(String email);
    Optional<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findByEmailContaining(String s);
}
