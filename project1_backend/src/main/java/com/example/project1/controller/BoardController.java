package com.example.project1.controller;

import com.example.project1.model.Board;
import com.example.project1.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
public class BoardController {
    @GetMapping
    public String getBoard() {
        return BoardService.getBoard();
    }

    @PostMapping
    public Boolean postBoard(@RequestBody Board board) {
        return BoardService.postBoard(board);
    }
}
