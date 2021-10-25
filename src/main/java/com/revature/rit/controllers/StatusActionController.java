package com.revature.rit.controllers;

public class StatusActionController {
}

/*import com.revature.rit.models.issues.StatusAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/statusactions")
public class StatusActionController implements ObjectController<StatusAction> {
    @Override
    public List<StatusAction> getAllData() {
        //TODO: Hook into database dao.

        //Ex: statusAction = dao.getAllStatusActions();
        List<StatusAction> statusAction = null;

        return statusAction;
    }

    @Override
    public ResponseEntity<StatusAction> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: statusAction = dao.getStatusAction(id);
        StatusAction statusAction = null;

        if (statusAction == null) {
            return new ResponseEntity<StatusAction>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<StatusAction>(statusAction, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(HttpServletRequest request, StatusAction obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create status action and insert into database.

            //Ex: dao.addStatusAction(statusAction);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/statusactions/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating status action.");
        }
    }
}*/
