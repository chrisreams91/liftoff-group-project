package org.launchcode.liftoffgroupproject.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.DateTimeException;
import java.util.Date;

public class Task {
    @NotBlank(message = "A task title is required")
    @Size(max = 30, message = "Title must be less than 30 characters")
    private String title;

    private DateTimeException startDate;

    @Size(min = 5, max = 100)
    private String description;

    private DateTimeException dueDate;
}
