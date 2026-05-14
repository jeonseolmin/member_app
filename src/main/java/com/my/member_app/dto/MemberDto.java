package com.my.member_app.dto;

import com.my.member_app.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long memberId;
    private String name;
    private int age;
    private String addr;

    public static Member toEntity(MemberDto dto){
        Member member = new Member();
        member.setMemberId(dto.memberId);
        member.setName(dto.name);
        member.setAge(dto.age);
        member.setAddr(dto.addr);
        return member;
    }

    public static MemberDto toDto(Member member){
        return new MemberDto(
                member.getMemberId(),
                member.getName(),
                member.getAge(),
                member.getAddr()
        );
    }
}
