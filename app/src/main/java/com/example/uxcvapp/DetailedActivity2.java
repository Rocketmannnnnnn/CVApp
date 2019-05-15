package com.example.uxcvapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedActivity2 extends AppCompatActivity {

    private ImageView picture;
    private TextView projectHeader;
    private TextView projectDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed2);

        this.picture = findViewById(R.id.detailedProjectImage);
        this.projectHeader = findViewById(R.id.detailedProjectTitle);
        this.projectDescription = findViewById(R.id.detailedProjectDescription);

        Project project = (Project) getIntent().getSerializableExtra("PROJECT_OBJECT");

        int resid = getResources().getIdentifier(
                project.getImageName(),
                "drawable",
                getPackageName()
        );
        this.picture.setImageResource(resid);
        this.projectHeader.setText(project.getTitle());
        this.projectDescription.setText(project.getProjectDescription());
    }
}
