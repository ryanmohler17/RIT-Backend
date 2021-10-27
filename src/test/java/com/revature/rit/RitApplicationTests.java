package com.revature.rit;

import com.revature.rit.mail.SendgridEmailer;
import com.revature.rit.reposistory.BoardListRepository;
import com.revature.rit.reposistory.BoardRepository;
import com.revature.rit.reposistory.CommentActionRepository;
import com.revature.rit.reposistory.IssueActionRepository;
import com.revature.rit.reposistory.IssueRepository;
import com.revature.rit.reposistory.StatusActionRepository;
import com.revature.rit.reposistory.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class RitApplicationTests {

    @MockBean
    BoardRepository boardRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    BoardListRepository boardListRepository;
    @MockBean
    CommentActionRepository commentActionRepository;
    @MockBean
    IssueActionRepository issueActionRepository;
    @MockBean
    IssueRepository issueRepository;
    @MockBean
    StatusActionRepository statusActionRepository;

    @Test
    void contextLoads() {
    }

}
