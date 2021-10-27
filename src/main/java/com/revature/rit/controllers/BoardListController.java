package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import com.revature.rit.models.boards.BoardList;
import com.revature.rit.reposistory.BoardListRepository;
import com.revature.rit.reposistory.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boardList")
@Transactional
@CrossOrigin("*")
public class BoardListController {

    @Autowired
    BoardListRepository boardListRepository;

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("/createBoardList")
    public ResponseEntity createBoardList(@RequestBody BoardList boardList) {
        try {
            Board board = boardRepository.findById(boardList.getBoard().getId()).get();
            BoardList _boardL = boardListRepository
                    .save(new BoardList(boardList.getTitle(), board));
            return new ResponseEntity<>(_boardL, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllBoardLists")
    public ResponseEntity<List<BoardList>> getAllBoardLists() {
        try {
            List<BoardList> boardLists = new ArrayList<BoardList>();
            Iterable<BoardList> boardListIterable = boardListRepository.findAll();
            boardListIterable.forEach(boardLists::add);
            return new ResponseEntity<>(boardLists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBoardListById/{id}")
    public ResponseEntity<BoardList> getBoardListById(@PathVariable("id") Integer id) {
        Optional<BoardList> boardListData = boardListRepository.findById(id);

        if (boardListData.isPresent()) {
            return new ResponseEntity<>(boardListData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateBoardList/{id}")
    public ResponseEntity<BoardList> updateBoardList(@PathVariable("id") Integer id, @RequestBody BoardList boardList) {
        List<String> availableFields = Arrays.asList("title","board");
        Optional<BoardList> boardListData = boardListRepository.findById(id);

        if (boardListData.isPresent()) {
            BoardList _boardList = boardListData.get();
            for (String field : availableFields) {
                switch (field){
                    case "title": if (boardList.getTitle() != null) _boardList.setTitle(boardList.getTitle()); break;
                    case "board": if (boardList.getBoard() != null) _boardList.setBoard(boardList.getBoard()); break;
                }
            }
            return new ResponseEntity<>(boardListRepository.save(_boardList), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}