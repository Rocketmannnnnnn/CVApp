package com.example.uxcvapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private ArrayList<Project> projects;

    public ProjectAdapter(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        Log.i("ProjectAdapter", "onCreateViewHolder called");
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.activity_detailed, viewGroup, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int i) {
        final Project project = this.projects.get(i);
//        Log.i("ProjectAdapter", "onBindViewHolder called for item " + i);
        //Get References from ProjectViewHolder and set text from 'project' variable
        int resid = projectViewHolder.itemView.getResources().getIdentifier(
                project.getImageName(),
                "drawable",
                projectViewHolder.itemView.getContext().getPackageName()
        );
        projectViewHolder.projectPicture.setImageResource(resid);
        projectViewHolder.projectTitle.setText(project.getTitle());
        projectViewHolder.year.setText(project.getYear());
    }

    @Override
    public int getItemCount() {
        return this.projects.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        public ImageView projectPicture;
        public TextView projectTitle;
        public TextView year;

        public ProjectViewHolder(@NonNull final View itemView) {
            super(itemView);

            this.projectPicture = itemView.findViewById(R.id.projectPicture);
            this.projectTitle = itemView.findViewById(R.id.ProjectTitle);
            this.year = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),DetailedActivity2.class);
//                    Log.i("POSITION", "" + ProjectViewHolder.super.getAdapterPosition());
                    Project project = projects.get(ProjectViewHolder.super.getAdapterPosition());
                    intent.putExtra("PROJECT_OBJECT", project);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
