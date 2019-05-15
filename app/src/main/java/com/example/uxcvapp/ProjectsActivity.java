package com.example.uxcvapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ProjectsActivity extends AppCompatActivity {

    private ArrayList<Project> projects;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        createProjects();
        this.recyclerView = findViewById(R.id.recyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ProjectAdapter(this.projects);
        this.recyclerView.setAdapter(this.adapter);
    }

    private void createProjects(){
        this.projects = new ArrayList<>();
        Project weatherstation = new Project("weatherstation", getString(R.string.weatherstation), getString(R.string.weatherstationDescription), "2018");
        Project boebot = new Project("robot", getString(R.string.boebot), getString(R.string.boebotDescription), "2018-2019");
        Project festivalPlanner = new Project("festivalplanner", getString(R.string.festivalPlanner), getString(R.string.festivalPlannerDescription), "2019");
        Project mobileApplication = new Project("dwergen", getString(R.string.mobileApplication), getString(R.string.mobileApplicationDescription), "2019");
        Project androidApp = new Project("screenshot", getString(R.string.cvapp), getString(R.string.cvappdescription),"2019");
        this.projects.add(weatherstation);
        this.projects.add(boebot);
        this.projects.add(festivalPlanner);
        this.projects.add(mobileApplication);
        this.projects.add(androidApp);
    }
}
