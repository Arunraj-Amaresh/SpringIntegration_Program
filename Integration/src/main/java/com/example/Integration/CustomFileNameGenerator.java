package com.example.Integration;



import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CustomFileNameGenerator implements FileNameGenerator {

    @Override
    public String generateFileName(Message<?> message) {
        return "out.csv";
    }
}
