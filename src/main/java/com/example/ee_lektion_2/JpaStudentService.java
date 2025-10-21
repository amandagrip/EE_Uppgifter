package com.example.ee_lektion_2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class JpaStudentService implements StudentService {
    @Override
    public String getStudentInfo(Long id) {
        return "Hello from JPA (id = " + id + ")";
    }
}
