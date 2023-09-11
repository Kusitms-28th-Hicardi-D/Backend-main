package com.example.hicardi.domain.member.entity;

import com.example.hicardi.domain.BaseEntity;
import com.example.hicardi.domain.solution.entity.Solution;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DemoOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demo_order_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organName;

    @Column(nullable = false)
    private String addInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_id")
    private Solution solution;

    private static DemoOrder createDemoOrderWithMember(String name, String organName, String addInfo, Member member, Solution solution){
        DemoOrder demoOrder = DemoOrder.builder()
                .name(name)
                .organName(organName)
                .addInfo(addInfo)
                .member(member)
                .solution(solution)
                .member(member)
                .build();
        return demoOrder;
    }
}
