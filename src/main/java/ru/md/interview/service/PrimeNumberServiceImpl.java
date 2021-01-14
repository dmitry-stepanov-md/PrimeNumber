package ru.md.interview.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

    @Override
    public Map<Integer, Integer> getCountByKeys(List<Integer> values) {
        Map<Integer, Integer> mapValues = new HashMap<>();

        for (Integer key : values) {
            if (isPrime(key))
                mapValues.put(key, mapValues.containsKey(key) ? mapValues.get(key) + 1 : 1);
        }

        return mapValues;
    }

    private boolean isPrime(Integer key) {
        if (key % 2 == 0 || key % 3 == 0)
            return false;

        for (int i = 5; i * i <= key; i += 6)
            if (key % i == 0 || key % (i + 2) == 0)
                return false;

        return true;
    }

}