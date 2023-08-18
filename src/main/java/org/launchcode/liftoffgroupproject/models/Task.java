package org.launchcode.liftoffgroupproject.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;

@Entity
public class Task extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskProgressEnum taskProgressEnum = TaskProgressEnum.TODO;

    @ManyToOne
    private User user;

    public Task(String name, String description, LocalDate startDate, LocalDate dueDate) {
        super();
        this.name = name;
        this.description = description;
        this.taskProgressEnum = TaskProgressEnum.TODO;
    }

    public Task() {
        }

        public User getUser () {
            return user;
        }

        public void setUser (User user){
            this.user = user;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }

        public TaskProgressEnum getTaskProgressEnum () {
            return taskProgressEnum;
        }

        public void setTaskProgressEnum (TaskProgressEnum taskProgressEnum){
            this.taskProgressEnum = taskProgressEnum;
        }


        @Override
        public String toString () {
            return name;
        }

        public LocalDate getStartDate () {
            return startDate;
        }

        public void setStartDate (LocalDate startDate){
            this.startDate = startDate;
        }

        public LocalDate getDueDate () {
            return dueDate;
        }

        public void setDueDate (LocalDate dueDate){
            this.dueDate = dueDate;
        }

    }
