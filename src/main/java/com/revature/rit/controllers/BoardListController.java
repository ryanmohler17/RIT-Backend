package com.revature.rit.controllers;

import com.revature.rit.models.boards.BoardList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/boardlists")
public class BoardListController implements ObjectController<BoardList> {
    @Override
    public List<BoardList> getAllData() {
        //TODO: Hook into database dao.

        //Ex: boardList = dao.getAllBoardLists();
        List<BoardList> boardLists = null;

        return boardLists;
    }

    @Override
    public ResponseEntity<BoardList> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: boardList = dao.getBoardList(id);
        BoardList boardList = null;

        if (boardList == null) {
            return new ResponseEntity<BoardList>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<BoardList>(boardList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(BoardList obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create board list and insert into database.

            //Ex: dao.addBoardList(boardList);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/boardlists/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating board list.");
        }
    }
}
