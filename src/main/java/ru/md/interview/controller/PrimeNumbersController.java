package ru.md.interview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.md.interview.service.PrimeNumberService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prime-number")
public class PrimeNumbersController {

    private final PrimeNumberService primeNumberService;

    public PrimeNumbersController(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
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
        return ResponseEntity.ok(primeNumberService.getCountByKeys(values));
    }

}
