package com.mehisen.jpaperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/getUsers")
    public ResponseEntity<String> getUsersFetchTime() {
        long startTime = System.nanoTime();
//        List<UserEntity> users = userRepository.findAllByCity("Cairo");
        List<UserEmailAndCityProjection> users = userRepository.findAllByCity("Cairo");
        long endTime = System.nanoTime();
        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;

        return ResponseEntity.ok("Time taken to fetch users: " + String.format("%.2f", durationSeconds) + " seconds");
    }
}
