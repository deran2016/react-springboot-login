package com.example.project1.service;

import com.example.project1.model.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class BoardService {
    public static String getBoard() {
        JSONParser parser = new JSONParser();

        try {
            String filename = "board.json";
            Object obj = parser.parse(new FileReader(filename));
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray.toJSONString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Board> getBoardList() {
        List<Board> boardList = new Gson().fromJson(getBoard(), new TypeToken<List<Board>>(){}.getType());

        return boardList;
    }

    public static Boolean postBoard(Board board) {
        List<Board> boardList = getBoardList();
        boardList.add(board);
        String str = new Gson().toJson(boardList);
        byte[] bytes = str.getBytes();

        try (OutputStream output = new FileOutputStream("userdata.json")) {
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
