package com.example.projecttrackersystem.Controller;

import com.example.projecttrackersystem.Api.ApiResponse;
import com.example.projecttrackersystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")


public class projectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/projects")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/post")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("project added successfully !", "200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("project updated successfully !", "200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("project deleted successfully !", "200");
    }

    @PutMapping("/changestatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        if(! projects.get(index).getStatus().equals("done")) {
            projects.get(index).setStatus("done");
            return new ApiResponse("status changes successfully !", "200");
        }
        return new ApiResponse("status already done !", "200");
    }

    @GetMapping("search/{title}")
    public Project searchProject(@PathVariable String title) {
        for(Project project : projects) {
            if(project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }

    @GetMapping("displaybycompany/{companyName}")
    public ArrayList<Project> displayByCompanyProject(@PathVariable String companyName) {
        ArrayList<Project> companyProjects = new ArrayList<>();
        for(Project project : projects) {
            if(project.getCompanyName().equals(companyName)) {
                companyProjects.add(project);
            }
        }
        return companyProjects;
    }








}
