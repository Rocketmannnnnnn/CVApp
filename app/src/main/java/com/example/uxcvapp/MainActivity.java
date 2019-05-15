package com.example.uxcvapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contactInfo;
    private TextView infoHeader;
    private TextView info;
    private ArrayAdapter mAdapter;
    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.contactInfo = findViewById(R.id.conactInfo);
        this.infoHeader = findViewById(R.id.infoHeaderTextView);
        this.info = findViewById(R.id.infoTextView);

        this.mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        this.spinner = findViewById(R.id.languageSpinner);
        this.spinner.setAdapter(mAdapter);
        this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        setallTexts(context.getResources());
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "nl");
                        setallTexts(context.getResources());
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
        this.button = findViewById(R.id.projectsButton);
        this.button.setText(getString(R.string.projectsHeader));
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ProjectsActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    public void setallTexts(Resources resources){
        this.contactInfo.setText(resources.getString(R.string.contactInfo));
        this.infoHeader.setText(resources.getString(R.string.infoHeaderTextView));
        this.info.setText(resources.getString(R.string.infoTextView));
        this.button.setText(getString(R.string.projectsHeader));
    }
}
