package com.example.jobsearch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "interview")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
