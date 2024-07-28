package com.example.projecttrackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Project {

    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;



}
