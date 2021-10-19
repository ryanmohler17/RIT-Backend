package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Board> getAllBoards() {
        //TODO: Hook into database dao.

        //Ex: boards = dao.getAllBoards();
        List<Board> boards = null;

        return boards;
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Board> getBoard(@PathVariable int id) {
        //TODO: Hook into database dao.

        //Ex: board = dao.getBoard(id);
        Board board = null;

        if (board == null) {
            return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBoard(@RequestBody Board board) {
        System.out.println(board); //Debug

        try {
            //TODO: Create board and insert into database.

            //Ex: dao.addBoard(board);

            return ResponseEntity.created(new URI("http://localhost:8080/boards/" + board.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating board.");
        }
    }
}
