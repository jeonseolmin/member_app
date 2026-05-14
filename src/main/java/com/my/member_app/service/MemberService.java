package com.my.member_app.service;

import com.my.member_app.dto.MemberDto;
import com.my.member_app.entity.Member;
import com.my.member_app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class MemberService  {
    private final MemberRepository memberRepository;

    public List<MemberDto> findAll(){
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(MemberDto::toDto)
                .collect(Collectors.toList());
    }

    public MemberDto findById(Long id){
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return MemberDto.toDto(member.get());
        }
        return null;
    }

    public void save(MemberDto dto){
        memberRepository.save(MemberDto.toEntity(dto));
    }

    public void deleteById(Long id){
        memberRepository.deleteById(id);
    }
}
