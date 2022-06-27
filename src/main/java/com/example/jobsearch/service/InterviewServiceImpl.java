package com.example.jobsearch.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {

    @Override
    @Transactional
    public void m1() {

    }

    @Override
    @Transactional
    public void m2() {

    }

    public void m3() {

        InterviewService interviewService = new InterviewServiceImpl();

        List<String> strings = new LinkedList<>();

        LinkedList<String> stringsLL = new LinkedList<>();
    }
}

// spring
// InterviewServiceImpl -> bean
// new InterviewServiceImpl()

// runtime class spring$$InterviewServiceImpl implements InterviewService

@Component
@Transactional // @Transactional applies to ALL methods
class A {

    // A a = new A();

    void m1() {}
    void m2() {}
    void m3() {}
}