package com.example.ee_lektion_2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class InMemoryStudentService implements StudentService {
    @Override
    public String getStudentInfo(Long id) {
        return "Hello from inMemory (id = " + id + ")";
    }
}
