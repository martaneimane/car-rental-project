package com.example.database;

import java.util.HashMap;
import java.util.Map;

public class NoSQLDatabaseService {
    private static Map<String, String> storage = new HashMap<>();

    public void putValue(String key, String object){
        storage.put(key, object);
    }

    public String getValue(String key) {return storage.get(key);}

    public void remove(String key) {storage.remove(key);}
}
