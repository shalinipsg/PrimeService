package com.shacheru.primesservice.Controller;
import com.shacheru.primesservice.Service.IPrimeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/primes")
@AllArgsConstructor
public class primeController {

    IPrimeService primeService;

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable long n) {
        return primeService.isPrime(n);
    }

}
