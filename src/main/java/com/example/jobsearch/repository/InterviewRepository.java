package com.example.jobsearch.repository;

import com.example.jobsearch.entity.Candidate;
import com.example.jobsearch.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    void deleteAllByCandidate(Candidate candidate);
}
