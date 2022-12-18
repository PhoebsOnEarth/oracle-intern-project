package com.example.oracleinternchallenge;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FibController {

    @CrossOrigin("http://localhost:3000")
    @RequestMapping ("/fibonacci")
    public ResponseEntity<Map<String,List<Long>>> Fib(@RequestParam("element")Long elem) {


        List<Long> fibArr = Fibonacci.GenFibArr(elem);
        List<Long> sorted = Fibonacci.SortedFibArr(fibArr);
        Map<String,List<Long>> res = new HashMap<>();
        res.put("fibonacci",fibArr);
        res.put("sorted",sorted);


        return ResponseEntity.ok().body(res);
    }


}
