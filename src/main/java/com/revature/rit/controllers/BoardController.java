package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
<<<<<<< HEAD
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
=======
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
>>>>>>> master
        }
    }
}
