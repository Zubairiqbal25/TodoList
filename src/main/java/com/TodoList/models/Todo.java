package com.TodoList.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Title can't be Empty..")
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean completed;
    private String latitude;
    private String longitude;

    public Todo(String title, String description, LocalDate dueDate, Boolean completed, String latitude,String longitude) {
        super();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id +
                ", title=" + title +
                ", description=" + description +
                ", dueDate=" + dueDate
                + ", completed=" + completed +
                ", latitude=" + latitude +
                ", longitude=" + longitude + "]";
    }
}
