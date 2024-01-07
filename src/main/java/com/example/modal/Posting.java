package com.example.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "postings")
@Getter
@Setter
public class Posting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long postingNumber;
    private int itemNumber;
    private Date contractDate;
    private Date postingDate;
    private String materialDescription;
    private int quantity;
    private String BUn;
    private double currencyAmount;
    private String currency;
    private String userName;
    private boolean isAuthorized;

    public Posting(long postingNumber, int itemNumber, Date contractDate, Date postingDate,
                   String materialDescription, int quantity, String BUn, double currencyAmount,
                   String currency, String userName, boolean isAuthorized) {
        this.postingNumber = postingNumber;
        this.itemNumber = itemNumber;
        this.contractDate = contractDate;
        this.postingDate = postingDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.BUn = BUn;
        this.currencyAmount = currencyAmount;
        this.currency = currency;
        this.userName = userName;
        this.isAuthorized = isAuthorized;
    }

    public Posting(){
        super();
    }
}
