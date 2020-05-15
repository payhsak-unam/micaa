package com.example.mica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    CardView job;
    CardView scholar;
    CardView intern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        job=findViewById(R.id.jobb);
        scholar=findViewById(R.id.scholarr);
        intern=findViewById(R.id.internn);

        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),MainActivity.class);
                startActivity(i);
            }
        });

        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),InternActivity.class);
                startActivity(i);
            }
        });

        scholar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),ScholarActivity.class);
                startActivity(i);
            }
        });

    }


}
