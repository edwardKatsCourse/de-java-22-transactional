package com.example.jobsearch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "candidate")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
