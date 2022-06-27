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
public class Runner1 implements CommandLineRunner {

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

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        interviewRepository.findAll();


        Candidate candidate = Candidate.builder()
                .name("John")
                .build();

        candidateRepository.save(candidate);

        if (true) {
            throw new RuntimeException();
        }

        var interviews = generateInterviews(candidate);
        interviewRepository.saveAll(interviews);

    }




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
