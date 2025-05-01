package com.example.springboot;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.*;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("machine")
    public static String machine() {
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("http://elvis.rowan.edu/~mckeep82/ds/machine_states/xN3b82lmTM.json"))
                                         .timeout(Duration.ofMinutes(1))
                                         .build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Machine m = null;
        try {
            m = objectMapper.readValue(response.body(), Machine.class);
        } catch (Exception e) {
            System.out.println(e);
        }

       return m.toString();
    }

    @RequestMapping("machine2")
    public static String machine2() {
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("http://elvis.rowan.edu/~mckeep82/ds/machine_states/vTnGy8QQAS.json"))
                                         .timeout(Duration.ofMinutes(1))
                                         .build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Machine m = null;
        try {
            m = objectMapper.readValue(response.body(), Machine.class);
        } catch (Exception e) {
            System.out.println(e);
        }

       return m.toString();
    }

}
