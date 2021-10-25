package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
import com.revature.rit.models.users.User;
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

    @PostMapping("/board/createBoard")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        try {
            User user = userRepository.findById(board.getCreator().getId()).get();
            Board _board = boardRepository
                    .save(new Board(board.getTitle(), board.getDescription(), user));
            System.out.println(_board);
            return new ResponseEntity<>(_board, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/board/getAllBoards")
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

    @GetMapping("/board/getBoardById/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable("id") Integer id) {
        Optional<Board> boardData = boardRepository.findById(id);

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/board/getBoardByCreatorId/{creator}")
    public ResponseEntity<Board> getBoardByCreator(@PathVariable("creator") User creator) {
        Optional<Board> boardData = boardRepository.findByCreatorId(creator.getId());

        if (boardData.isPresent()) {
            return new ResponseEntity<>(boardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/board/updateBoard/{id}")
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
            _board.setCreatedAt(LocalDateTime.now());
            return new ResponseEntity<>(boardRepository.save(_board), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

/*import com.revature.rit.models.boards.Board;
import org.springframework.http.HttpStatus;
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
}*/
