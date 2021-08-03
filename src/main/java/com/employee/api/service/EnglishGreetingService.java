package com.employee.api.service;

import com.employee.api.repository.EnglishGreetingRepository;

public class EnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public EnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
