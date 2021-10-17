package com.revature.rit.models.boards;

import com.revature.rit.models.issues.Issue;
import lombok.Data;

import java.util.List;

@Data
public class BoardList {
    private int id;
    private String title;
    private List<Issue> issues;
}
