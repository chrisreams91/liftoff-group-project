package org.launchcode.liftoffgroupproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Task extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;
    private String startDate;
    private String dueDate;

    @ManyToOne
    private User user;

    public Task(User user, String name, String description, String startDate, String dueDate) {
        super();
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.user = user;
    }

    public Task() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return name;
    }

}
