package com.example.Integration;

import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class FileProcessor implements FileNameGenerator {

    public Message<String> processFile(Message<File> message) throws Exception {
        File inputFile = message.getPayload();
        String content;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)))) {
            content = reader.lines().collect(Collectors.joining("\n"));
        }

        String processedContent = processContent(content);

        writeToFile(processedContent);

        clearFileContent(inputFile);

        return MessageBuilder.withPayload(processedContent)
                             .setHeader(FileHeaders.FILENAME, "out.csv")
                             .build();
    }

    private String processContent(String content) {

    	return content;
    }

    private void writeToFile(String content) throws Exception {
        File outputFile = new File("C:/Users/BSIT-021/Documents/workspace-spring-tool-suite-4-4.23.1.RELEASE/Integration/src/main/java/out.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.write(content);
            writer.newLine();
        }
    }

    private void clearFileContent(File file) throws Exception {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
        }
    }

	@Override
	public String generateFileName(Message<?> message) {
		// TODO Auto-generated method stub
		return "out.csv";
	}
}
