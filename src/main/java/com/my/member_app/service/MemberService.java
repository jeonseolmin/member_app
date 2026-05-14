package com.my.member_app.service;

import com.my.member_app.dto.MemberDto;
import com.my.member_app.entity.Member;
import com.my.member_app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class MemberService  {
    // 의존성 주입 : 필요한 컴포넌트(인스턴스)를 불러오는 작업.
    // @Autowired // 1. 의존성 주입 방법
    // MemberRepository memberRepository;
    // 2. 생성자 주입 방법
//    private final MemberRepository memberRepository;
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
    // 3.@RequiredArgsConstructor // private final의 생성자 자동 생성.
    private final MemberRepository memberRepository;


    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return  members.stream()
                .map(MemberDto::toDto)
                .collect(Collectors.toList());
    }
}
