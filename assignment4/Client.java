import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {

        String serializedStack = getEndpointString("stack");
        String serializedLinkedList = getEndpointString("linkedList");
        String serializedArrayList = getEndpointString("arrayList");
        String serializedHashMap = getEndpointString("hashMap");

        System.out.println(deserializeStack(serializedStack).toString());
        System.out.println(deserializeLinkedList(serializedLinkedList).toString());
        System.out.println(deserializeArrayList(serializedArrayList).toString());
        System.out.println(deserializeHashMap(serializedHashMap).toString());
    }

    @SuppressWarnings("deprecation")
    public static String getEndpointString(String endpoint) {
        URL url = null;

        try {
            url = new URL("http://localhost:8080/" + endpoint);
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

        HttpURLConnection hurlc = null;
        try {
            hurlc = (HttpURLConnection) url.openConnection();
            hurlc.setRequestMethod("GET");
        } catch (IOException e) {
            System.out.println(e);
        }

        StringBuilder sb = new StringBuilder();
        String inputLine;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((hurlc.getInputStream())));
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return sb.toString();
    }

    public static Stack<Integer> deserializeStack(String serializedStack) {
        Stack<Integer> stack = new Stack();

        String[] serializedStackArray = serializedStack
            .substring(1, serializedStack.length()-2)
            .split(", ");

        for (int i = 0; i < serializedStackArray.length; i++) {
            stack.push(Integer.valueOf(serializedStackArray[i]));
        }

        return stack;
    }

    public static LinkedList<Integer> deserializeLinkedList(String serializedLinkedList) {
        LinkedList<Integer> linkedList = new LinkedList();

        String[] serializedLinkedListArray = serializedLinkedList
            .substring(1, serializedLinkedList.length()-2)
            .split(", ");

        for (int i = 0; i < serializedLinkedListArray.length; i++) {
            linkedList.add(Integer.valueOf(serializedLinkedListArray[i]));
        }

        return linkedList;
    }

    public static ArrayList<Integer> deserializeArrayList(String serializedArrayList) {
        ArrayList<Integer> arrayList = new ArrayList();

        String[] serializedArrayListArray = serializedArrayList
            .substring(1, serializedArrayList.length()-2)
            .split(", ");

        for (int i = 0; i < serializedArrayListArray.length; i++) {
            arrayList.add(Integer.valueOf(serializedArrayListArray[i]));
        }

        return arrayList;
    }

    public static HashMap<Integer, Integer> deserializeHashMap(String serializedHashMap) {
        HashMap<Integer, Integer> hashMap = new HashMap();

        String[] serializedHashMapArray = serializedHashMap
            .substring(1, serializedHashMap.length()-1)
            .split(", ");

        for (int i = 0; i < serializedHashMapArray.length; i++) {
            hashMap.put(Integer.valueOf(serializedHashMapArray[i].substring(0, 1)),
                    Integer.valueOf(serializedHashMapArray[i].substring(2)));
        }

        return hashMap;
    }
}
