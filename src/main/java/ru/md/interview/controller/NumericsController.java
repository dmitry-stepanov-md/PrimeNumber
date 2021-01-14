package ru.md.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.md.interview.service.NumericService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/numerics")
public class NumericsController {

    private final NumericService numericService;

    public NumericsController(NumericService numericService) {
        this.numericService = numericService;
    }

    @GetMapping()
    public ResponseEntity index() {
        return new ResponseEntity("Empty array", HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(
            value = "/{values}",
            method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, Integer>> mapping(@PathVariable List<Integer> values) { //@PathVariable Integer[] values
        if (values == null) {
            return new ResponseEntity("Empty array", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(numericService.getCountByKeys(values));
    }

}
