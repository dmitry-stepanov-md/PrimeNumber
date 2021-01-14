package ru.md.interview.service;

import java.util.List;
import java.util.Map;

public interface NumericService {
    Map<Integer, Integer> getMapValues();
    Map<Integer, Integer> getCountByKeys(List<Integer> values);

    Integer getById(Integer id);
}