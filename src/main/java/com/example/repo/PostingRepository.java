package com.example.repo;

import com.example.modal.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    ArrayList<Posting> findAll();
    ArrayList<Posting> findByContractDateAfterAndPostingDateBeforeAndIsAuthorized(Date postingDate, Date endDate,
                                                               boolean isAuthorized);
    ArrayList<Posting> findByContractDateAfterAndPostingDateBefore(Date postingDate, Date endDate);
}
