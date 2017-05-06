package com.tmasuda.fc.repo;

import com.tmasuda.fc.model.Event;
import com.tmasuda.fc.model.EventBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Currency;

public interface EventBalanceRepo extends JpaRepository<EventBalance, Long> {

    EventBalance findOneByEventAndCurrency(Event event, Currency currency);

}
