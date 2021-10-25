package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
//@Table(name = "status_action")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class StatusAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private IssueStatus status;

    @Column(name = "status_name")
    private String statusName;
}
