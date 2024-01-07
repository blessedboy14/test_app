package com.example.service;

import com.example.modal.Posting;
import com.example.repo.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostingServiceImpl implements PostingService{
    @Autowired
    PostingRepository postingRepository;
    @Override
    public ArrayList<Posting> findAllPosting() {
        return postingRepository.findAll();
    }

    @Override
    public ArrayList<Posting> findByContractDateAfterAndPostingDateBeforeAndIsAuthorized(Date startDate, Date endDate, boolean isAuthorized) {
        return postingRepository.findByContractDateAfterAndPostingDateBeforeAndIsAuthorized(startDate, endDate, isAuthorized);
    }

    @Override
    public ArrayList<Posting> findByContractDateAfterAndPostingDateBefore(Date postingDate, Date endDate) {
        return postingRepository.findByContractDateAfterAndPostingDateBefore(postingDate, endDate);
    }

    @Override
    public void addPosting() {

    }

    @Override
    public void addPosting(Posting posting) {
        postingRepository.save(posting);
    }

    @Override
    public void deleteAllData() {
        postingRepository.deleteAll();
    }
}
