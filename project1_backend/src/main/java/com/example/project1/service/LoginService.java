package com.example.project1.service;

import com.example.project1.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginService {
    public static String Login(String data) {
        JSONObject jsonData = new Gson().fromJson(data, new TypeToken<JSONObject>(){}.getType());

        List<User> userList = getUserList();

        for (User i : userList) {
            if (i.getEmail().equals(jsonData.get("email")) && i.getPassword().equals(jsonData.get("password"))) {
                return new Gson().toJson(i);
            }
        }

        return null;
    }

    public static List<User> getUserList() {
        JSONParser parser = new JSONParser();

        try {
            String filename = "userdata.json";
            Object obj = parser.parse(new FileReader(filename));
            JSONArray jsonArray = (JSONArray) obj;

            List<User> userList = new Gson().fromJson(jsonArray.toJSONString(), new TypeToken<List<User>>(){}.getType());

            return userList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
