package com.example.shop.Entity;


import com.example.shop.constant.Role;
import com.example.shop.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "member")
@Getter
@Setter
@ToString

public class Member {


    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(member.getName());
        member.setEmail(member.getEmail());
        member.setAddress(member.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(member.getPassword());
        member.setRole(Role.USER);
        return member;
    }
}
