package com.example.controller;

import com.example.csv.CSVData;
import com.example.csv.CSVReader;
import com.example.csv.MyCSVReader;
import com.example.csv.SupportMethods;
import com.example.modal.Posting;
import com.example.service.PostingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class MainController {

    private final PostingServiceImpl postingService;

    @Autowired
    public MainController(PostingServiceImpl postingService) {
        this.postingService = postingService;
    }

    @GetMapping("/findAll")
    public ArrayList<Posting> getAllPostings() {
        return postingService.findAllPosting();
    }

    @GetMapping("/findByDate")
    public ArrayList<Posting> getByPeriod(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam(required = false) String isAuthorized
            ) {
        if (isAuthorized == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            try {
                return postingService.findByContractDateAfterAndPostingDateBefore(
                        formatter.parse(startDate), formatter.parse(endDate));
            } catch (ParseException e) {
                return null;
            }
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            try {
                return postingService.findByContractDateAfterAndPostingDateBeforeAndIsAuthorized(
                        formatter.parse(startDate), formatter.parse(endDate), Boolean.parseBoolean(isAuthorized));
            } catch (ParseException e) {
                return null;
            }
        }
    }

    @PostMapping("/addAll")
    public void addAll() {
        CSVReader myReader = new MyCSVReader();
        CSVData logins = myReader.readAll("logins.csv", ',', false);
        CSVData postings = myReader.readAll("postings.csv", ';', true);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        if (logins != null && postings != null) {
            boolean result = SupportMethods.complementPostingsData(postings, logins);
            try {
                for (String[] posting : postings.getData()) {
                    Posting p = new Posting(Long.parseLong(posting[0]), Integer.parseInt(posting[1]),
                            formatter.parse(posting[2]), formatter.parse(posting[3]), posting[4], Integer.parseInt(posting[5]),
                            posting[6], Double.parseDouble(posting[7].replace(",", ".")),
                            posting[8], posting[9], Boolean.parseBoolean(posting[10]));
                    postingService.addPosting(p);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Reading csv error");
        }
    }

}
