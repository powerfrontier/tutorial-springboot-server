package com.ccsw.tutorial.borrow;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.borrow.model.Borrow;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    @Query("select b from Borrow b where (:gameId is null or b.game.id = :gameId)"
            + " and (:customerId is null or b.customer.id = :customerId)"
            + " and (:date is null or ( (b.startDate<=:date) and (:date<=b.finishDate)))")
    Page<Borrow> findAll(Pageable pageable, @Param("gameId") Long gameId, @Param("customerId") Long customerId,
            @Param("date") Date date);

    @Query("select b from Borrow b where b.game.id = :gameId and ((finish_date between :startDate and :finishDate) "
            + " or (start_date between :startDate and :finishDate) "
            + " or (start_date <= :startDate and finish_date >= :finishDate))")
    List<Borrow> gameOnDates(@Param("gameId") Long gameId, @Param("startDate") Date startDate,
            @Param("finishDate") Date finishDate);

    @Query("select b from Borrow b where b.customer.id = :customerId and ((finish_date between :startDate and :finishDate) "
            + " or (start_date between :startDate and :finishDate) "
            + " or (start_date <= :startDate and finish_date >= :finishDate))")
    List<Borrow> customerOnDates(@Param("customerId") Long customerId, @Param("startDate") Date startDate,
            @Param("finishDate") Date finishDate);
}
