package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Spending;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemorySpendingRepository implements SpendingRepository {
    private final List<Spending> spendings = new ArrayList<>();

    public InMemorySpendingRepository(){
        IntStream.range(1, 3).forEach(i -> this.spendings.add(new Spending(i, "Spending %d".formatted(i),
                i * 5.5)));
    }
    @Override
    public List<Spending> getAll() {
        return Collections.unmodifiableList(this.spendings);
    }
}
