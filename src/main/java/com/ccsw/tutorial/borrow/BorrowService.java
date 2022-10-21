package com.ccsw.tutorial.borrow;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.borrow.model.Borrow;
import com.ccsw.tutorial.borrow.model.BorrowDto;
import com.ccsw.tutorial.borrow.model.BorrowSearchDto;
import com.ccsw.tutorial.model.ResultDto;

public interface BorrowService {

    Page<Borrow> findPage(BorrowSearchDto borrowSearchDto);

    ResultDto save(BorrowDto borrowDto);

    void delete(Long id);

}
