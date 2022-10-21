package com.ccsw.tutorial.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.borrow.model.BorrowDto;
import com.ccsw.tutorial.borrow.model.BorrowSearchDto;
import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.model.ResultDto;

@RestController
@RequestMapping(value = "/borrow")
@CrossOrigin(origins = "*")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<BorrowDto> findPage(@RequestBody BorrowSearchDto borrowSearchDto) {

        return beanMapper.mapPage(borrowService.findPage(borrowSearchDto), BorrowDto.class);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResultDto save(@RequestBody BorrowDto borrowDto) {

        return borrowService.save(borrowDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {

        borrowService.delete(id);
    }

}
