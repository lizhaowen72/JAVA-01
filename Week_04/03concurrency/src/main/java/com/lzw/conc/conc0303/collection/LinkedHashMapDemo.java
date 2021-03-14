package com.lzw.conc.conc0303.collection;

import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        System.out.println("=====>1.test hash map");
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("name1","josan1");
        hashMap.put("name2","josan2");
        hashMap.put("name3","josan3");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:"+key+",value:"+value);
        }
        System.out.println("=====>2.test linked hash map");
        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1","josan1");
        linkedHashMap.put("name2","josan2");
        linkedHashMap.put("name3","josan3");
        Set<Map.Entry<String, String>> set1 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> entry = iterator1.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:"+key+",value:"+value);
        }
    }
}
