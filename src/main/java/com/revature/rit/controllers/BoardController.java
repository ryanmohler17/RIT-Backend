package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import com.revature.rit.models.users.User;
import com.revature.rit.repos.BoardRepository;
import com.revature.rit.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Transactional
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/board")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        try {
            User user = userRepository.getById(board.getCreator().getId());
            Board _board = boardRepository
                    .save(new Board(board.getTitle(), board.getDescription(), user.getId(), LocalDateTime.now()));
            return new ResponseEntity<>(_board, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/board/getBoardById/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable("id") int id) {
        Optional<Board> boardData = boardRepository.findById(id);

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/board/getBoardByCreator/{creator}")
    public ResponseEntity<Board> getBoardByCreator(@PathVariable("creator") Integer creatorId) {
        Optional<Board> boardData = boardRepository.findByCreatorId(creatorId);

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") int id, @RequestBody Board board) {
        Optional<Board> boardData = boardRepository.findById(id);

        if (boardData.isPresent()) {
            Board _board = boardData.get();
            _board.setTitle(board.getTitle());
            _board.setDescription(board.getDescription());
            _board.setCreator(board.getCreator());
            _board.setCreatedAt(board.getCreatedAt());
            return new ResponseEntity<>(boardRepository.save(_board), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
