package com.example.uxcvapp;

import java.io.Serializable;

public class Project implements Serializable {

    private String imageName;
    private String title;
    private String projectDescription;
    private String year;

    public Project(String imageName, String title, String projectDescription, String year) {
        this.imageName = imageName;
        this.title = title;
        this.projectDescription = projectDescription;
        this.year = year;
    }

    public String getImageName() {
        return imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getYear() {
        return year;
    }
}
