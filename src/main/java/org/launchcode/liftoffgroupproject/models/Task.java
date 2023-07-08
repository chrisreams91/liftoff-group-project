package org.launchcode.liftoffgroupproject.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Task {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;
    private String startDate;
    private String dueDate;

    public Task(String name, String description, String startDate, String dueDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.id = nextId;
        nextId++;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
