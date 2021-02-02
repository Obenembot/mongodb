package com.example.myrunner;

import com.example.models.Country;
import com.example.models.Student;
import com.example.repositories.CountryRepository;
import com.example.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StudentRepository studentRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        countryRepository.deleteAll();
        
        countryRepository.save(new Country("China", 1382050000));
        countryRepository.save(new Country("India", 1313210000));
        countryRepository.save(new Country("Cameroon", 1313210000));
        countryRepository.save(new Country("France", 1382050000));
        countryRepository.save(new Country("Nigeria", 1313210000));
        countryRepository.save(new Country("Mali", 1313210000));
        
        studentRepository.save(new Student("oben","oben@gmail.com","12345"));
        studentRepository.save(new Student("Tabi","tabi@gmail.com","12345"));
        studentRepository.save(new Student("Nkeng","Nkeng@gmail.com","12345"));
        countryRepository.findAll().forEach((country) -> {
            logger.info("{}", country);
        });
        studentRepository.findAll().forEach((student) -> {
            logger.info("{}", student);
        });
    }
}
