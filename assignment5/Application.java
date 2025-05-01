package hello;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("stack")
    public static String stack() {

        Stack<Integer> stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(stack);
        } catch (Exception e) {
            System.out.println(e);
        }

        return json;
    }

    @RequestMapping("arrayList")
    public static String arrayList() {

        ArrayList<Integer> arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(arrayList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return json;
    }

    @RequestMapping("hashMap")
    public static String hashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(5, 5);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            json = objectMapper.writeValueAsString(hashMap);
        } catch (Exception e) {
            System.out.println(e);
        }

        return json;
    }

    @PostMapping("postHashMap")
    public static String postHashMap(@RequestBody String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        HashMap<Integer, Integer> hashMap = null;
        String json = null;
        try {
            hashMap = objectMapper.readValue(message, HashMap.class);

            hashMap.put(8, 4);
            hashMap.put(10, 5);
            hashMap.put(12, 6);
            hashMap.put(14, 7);
            hashMap.put(16, 8);
            hashMap.put(18, 9);

            json = objectMapper.writeValueAsString(hashMap);
        } catch (Exception e) {
            System.out.println(e);
        }

        return json.toString();
    }

    @PostMapping("postCar")
    public static String postCar(@RequestBody String message) {
        Car car = null;

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;
        try {
            car = objectMapper.readValue(message, Car.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        return car.toString();
    }
}
