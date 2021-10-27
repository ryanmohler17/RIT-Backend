package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import com.revature.rit.models.boards.BoardList;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.BoardListRepository;
import com.revature.rit.reposistory.BoardRepository;
import com.revature.rit.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/board")
@Transactional
@CrossOrigin("*")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardListRepository boardListRepository;

    @PostMapping("/createBoard")
    public ResponseEntity createBoard(@RequestBody Board board) {
        try {
            User user = userRepository.findById(board.getCreator().getId()).get();
            Board _board = boardRepository
                    .save(new Board(board.getTitle(), board.getDescription(), user));
            System.out.println(_board);
            return new ResponseEntity<>(_board, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllBoards")
    public ResponseEntity<List<Board>> getAllBoards() {
        try {
            List<Board> boardList = new ArrayList<Board>();
            Iterable<Board> boards = boardRepository.findAll();
            boards.forEach(boardList::add);
            return new ResponseEntity<>(boardList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBoardById/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable("id") Integer id) {
        Optional<Board> boardData = boardRepository.findById(id);

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getBoardByCreatorId/{creator}")
    public ResponseEntity<Board> getBoardByCreator(@PathVariable("creator") User creator) {
        Optional<Board> boardData = boardRepository.findByCreatorId(creator.getId());

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateBoard/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") Integer id, @RequestBody Board board) {
        List<String> availableFields = Arrays.asList("title","description","creator");
        Optional<Board> boardData = boardRepository.findById(id);

        if (boardData.isPresent()) {
            Board _board = boardData.get();
            for (String field : availableFields) {
                switch (field){
                    case "title": if (board.getTitle() != null) _board.setTitle(board.getTitle()); break;
                    case "description": if (board.getDescription() != null) _board.setDescription(board.getDescription()); break;
                    case "creator": if (board.getCreator() != null) _board.setCreator(board.getCreator()); break;
                }
            }
            for (BoardList list : board.getLists()) {
                boolean hasList = _board.getLists().stream().anyMatch(boardList -> Objects.equals(boardList.getId(), list.getId()));
                list.setBoard(_board);
                BoardList newList = boardListRepository.save(list);
                if (!hasList) {
                    _board.getLists().add(newList);
                }
            }
            return new ResponseEntity<>(boardRepository.save(_board), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}