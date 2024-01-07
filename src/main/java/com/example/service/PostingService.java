package com.example.service;

import com.example.modal.Posting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface PostingService {
    ArrayList<Posting> findAllPosting();
    ArrayList<Posting> findByContractDateAfterAndPostingDateBeforeAndIsAuthorized(Date startDate, Date endDate,
                                                               boolean isAuthorized);
    ArrayList<Posting> findByContractDateAfterAndPostingDateBefore(Date postingDate, Date endDate);
    void addPosting();
    void addPosting(Posting posting);
    void deleteAllData();
}
