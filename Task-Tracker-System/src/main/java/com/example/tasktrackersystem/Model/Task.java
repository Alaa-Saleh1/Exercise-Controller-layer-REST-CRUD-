package com.example.tasktrackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int ID;
    private String title;
    private String description;
    private String status;
}
