package assignment4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

        return stack.toString();
    }

    @RequestMapping("linkedList")
    public static String linkedList() {

        LinkedList<Integer> linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        return linkedList.toString();
    }

    @RequestMapping("arrayList")
    public static String arrayList() {

        ArrayList<Integer> arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        return arrayList.toString();
    }

    @RequestMapping("hashMap")
    public static String hashMap() {
        HashMap<Integer, Integer> hashmap = new HashMap();

        hashmap.put(1, 1);
        hashmap.put(2, 2);
        hashmap.put(3, 3);
        hashmap.put(4, 4);
        hashmap.put(5, 5);

        return hashmap.toString();
    }
}
