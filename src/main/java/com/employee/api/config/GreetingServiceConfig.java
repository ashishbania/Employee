package com.employee.api.config;

import com.employee.api.repository.EnglishGreetingRepository;
import com.employee.api.repository.EnglishGreetingRepositoryImpl;
import com.employee.api.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile({"EN","default"})
    @Bean("i18nService")
    EnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new EnglishGreetingService(englishGreetingRepository);
    }
    @Profile({"ES"})
    @Bean("i18nService")
    SpanishGreetingService i18nSpanishService(){
        return new SpanishGreetingService();
    }
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
    @Bean
    SetterInjectGreetingService setterInjectGreetingService(){
        return new SetterInjectGreetingService();
    }
}
