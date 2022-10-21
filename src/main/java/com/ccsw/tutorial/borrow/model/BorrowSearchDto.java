package com.ccsw.tutorial.borrow.model;

import java.util.Date;

import org.springframework.data.domain.Pageable;

public class BorrowSearchDto {

    private Pageable pageable;
    private Long gameId;
    private Long customerId;
    private Date date;

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
