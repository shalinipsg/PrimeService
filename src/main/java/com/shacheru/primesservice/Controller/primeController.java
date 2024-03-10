package com.shacheru.primesservice.Controller;
import com.shacheru.primesservice.Service.IPrimeService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/primes")

public class primeController {
@Autowired
    IPrimeService primeService;

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable long n) {
        return primeService.isPrime(n);
    }

}
