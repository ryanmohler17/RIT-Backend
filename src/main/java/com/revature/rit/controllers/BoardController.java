package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController implements ObjectController<Board> {
    @Override
    public List<Board> getAllData() {
        //TODO: Hook into database dao.

        //Ex: boards = dao.getAllBoards();
        List<Board> boards = null;

        return boards;
    }

    @Override
    public ResponseEntity<Board> getData(int id) {
        System.out.println(id); //Debug

        //TODO: Hook into database dao.

        //Ex: board = dao.getBoard(id);
        Board board = null;

        if (board == null) {
            return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(HttpServletRequest request, Board obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create board and insert into database.

            //Ex: dao.addBoard(board);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/boards/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating board.");
        }
    }
}
