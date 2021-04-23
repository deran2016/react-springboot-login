package com.example.project1.service;

import com.example.project1.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class RegisterService {
    public static Boolean Register(User user) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("userdata.json"));
            JSONArray jsonArray = (JSONArray) obj;

            List<User> userList = new Gson().fromJson(jsonArray.toJSONString(), new TypeToken<List<User>>(){}.getType());
            for (User i: userList) {
                if (i.getEmail().equals(user.getEmail())) return false;
            }
            userList.add(user);
            String str = new Gson().toJson(userList);
            byte[] bytes = str.getBytes();

            try (OutputStream output = new FileOutputStream("userdata.json")) {
                output.write(bytes);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return true;
    }
}
