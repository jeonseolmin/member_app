package com.my.member_app.repository;

import com.my.member_app.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query(value = "SELECT * FROM member order by age", nativeQuery = true)
    List<Member> searchAll();

    @Query(value = "SELECT * FROM member WHERE name LIKE %:keyword% ORDER BY id",
            nativeQuery = true)
    List<Member> searchByName(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM member WHERE addr LIKE %:keyword% ORDER BY id", nativeQuery = true)
    List<Member> searchByAddr(@Param("keyword")String keyword);
}
