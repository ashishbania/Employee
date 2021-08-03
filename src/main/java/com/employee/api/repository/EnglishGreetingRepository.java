package com.employee.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnglishGreetingRepository {
    String getGreeting();
}
