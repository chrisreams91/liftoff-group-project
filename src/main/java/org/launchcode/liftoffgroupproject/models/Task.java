package org.launchcode.liftoffgroupproject.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class Task {
    @NotBlank(message = "A task title is required")
    @Size(max = 30, message = "Title must be less than 30 characters")
    private String title;

    private Date startDate;

    @Size(min = 5, max = 100)
    private String description;

    private Date dueDate;
}
