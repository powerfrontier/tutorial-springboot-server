package com.ccsw.tutorial.borrow;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.borrow.model.Borrow;
import com.ccsw.tutorial.borrow.model.BorrowDto;
import com.ccsw.tutorial.borrow.model.BorrowSearchDto;
import com.ccsw.tutorial.customer.CustomerService;
import com.ccsw.tutorial.customer.model.CustomerDto;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.game.model.GameDto;
import com.ccsw.tutorial.model.ResultDto;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    GameService gameService;

    @Autowired
    CustomerService customerService;

    @Override
    public Page<Borrow> findPage(BorrowSearchDto borrowSearchDto) {

        // System.out.println(borrowSearchDto.getDate());
        return (Page<Borrow>) borrowRepository.findAll(borrowSearchDto.getPageable(), borrowSearchDto.getGameId(),
                borrowSearchDto.getCustomerId(), borrowSearchDto.getDate());
    }

    @Override
    public ResultDto save(BorrowDto borrowDto) {

        ResultDto result = new ResultDto();

        // Checks
        if (borrowDto.getStartDate().before(borrowDto.getFinishDate())) {

            if (TimeUnit.DAYS.convert(
                    Math.abs(borrowDto.getFinishDate().getTime() - borrowDto.getStartDate().getTime()),
                    TimeUnit.MILLISECONDS) <= 14) {

                if (availableGame(borrowDto.getGame(), borrowDto.getStartDate(), borrowDto.getFinishDate())) {

                    if (availableCustomer(borrowDto.getCustomer(), borrowDto.getStartDate(),
                            borrowDto.getFinishDate())) {

                        Borrow borrow = new Borrow();

                        BeanUtils.copyProperties(borrowDto, borrow, "id", "game", "customer");
                        borrow.setGame(gameService.get(borrowDto.getGame().getId()));
                        borrow.setCustomer(customerService.get(borrowDto.getCustomer().getId()));

                        borrowRepository.save(borrow);

                        result.setResult(1);
                        result.setDescription("Everything OK: new borrow created with ID: " + borrow.getId());
                    } else {
                        result.setResult(-4);
                        result.setDescription("Error: Same customer with 2 games on the same period");
                    }
                } else {
                    result.setResult(-3);
                    result.setDescription("Error: Same game with 2 customers on the same period");
                }
            } else {
                result.setResult(-2);
                result.setDescription("Error: Borrow exceeds the max period of 14 days");
            }
        } else {
            result.setResult(-1);
            result.setDescription("Error: Start date not before finish date");
        }

        return result;
    }

    private boolean availableCustomer(CustomerDto customer, Date startDate, Date finishDate) {

        List<Borrow> aux = borrowRepository.customerOnDates(customer.getId(), startDate, finishDate);
        if (aux.size() > 0)
            return false;
        else
            return true;
    }

    private boolean availableGame(GameDto game, Date startDate, Date finishDate) {

        List<Borrow> aux = borrowRepository.gameOnDates(game.getId(), startDate, finishDate);
        if (aux.size() > 0)
            return false;
        else
            return true;
    }

    @Override
    public void delete(Long id) {

        borrowRepository.deleteById(id);
    }

}
