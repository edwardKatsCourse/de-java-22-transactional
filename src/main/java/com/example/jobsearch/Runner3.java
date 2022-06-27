package com.example.jobsearch;

import com.example.jobsearch.entity.Candidate;
import com.example.jobsearch.entity.Interview;
import com.example.jobsearch.repository.CandidateRepository;
import com.example.jobsearch.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

//@Component
public class Runner3 implements CommandLineRunner {

    // 1. starting server
    // 2. configuring application context
    // 3. connecting to database
    //
    // n. Runner -> CommandLineRunner + spring bean
    // server started on port 8080

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    // Фокусы @Transactional
    // 1. exception in the middle - save-all-or-nothing
    //      SimpleJpaRepository - for findAll() ...spring already has a @Transactional
    //      custom deleteByCandidate() without @Transactional
    // 2. entity lifecycle - hibernate watches after each entity inside transaction
    // 3. 1st layer cache - hibernate keeps entity in-memory during transaction
    //      2nd layer cache (libraries, like EcCache)
    //      query cache
    // 4. propagation (nested transactions)

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // begin transaction

        Candidate candidate = Candidate.builder()
                .name("John")
                .build();

        candidateRepository.save(candidate);
        // managed

        System.out.println(candidate.getId());

        for (int i = 0; i < 10_000; i++) {
            candidateRepository.findById(1L);
            // id = 1
            // name = john
        }

        //

        // Cache
        // 1st layer cache - Session/Transaction
        // 2nd layer cache - SessionFactory
        // query cache

    }
    // end transaction


    private List<Interview> generateInterviews(Candidate candidate) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Stream
                .generate(() -> Interview.builder()
                        .companyName("company_" + atomicInteger.incrementAndGet())
                        .candidate(candidate)
                        .build()
                )
                .limit(5)
                .toList();
    }
}
