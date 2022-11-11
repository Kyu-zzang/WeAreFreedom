package io.github.weAreFreedom.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String member_id;
    @Column(length = 20, nullable = false)
    private String name;
    private String email;
    private String phone;

    private LocalDateTime regDt;
    private LocalDateTime udpDt;

    public Member createMember(String member_id, String name, String email, String phone){
        return Member.builder()
                .member_id(member_id)
                .name(name)
                .email(email)
                .phone(phone)
                .build();
    }
}
