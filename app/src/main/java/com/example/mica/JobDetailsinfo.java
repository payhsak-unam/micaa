package com.example.mica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.mica.Model.Intern;

public class JobDetailsinfo extends AppCompatActivity {

    ImageView logoo;
    TextView company_name;
    TextView jobtit;
    TextView jbber;
    Button avail;
    TextView st;
    TextView en;
    TextView requir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detailsinfo);

        initviews();
        setData();


        requir.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        avail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.google.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
    public void initviews()
    {
        avail=findViewById(R.id.availit);
        logoo=findViewById(R.id.joblogo);
        company_name=findViewById(R.id.Company);
        jobtit=findViewById(R.id.intern_title);
        jbber=findViewById(R.id.jobdesc);
        requir=findViewById(R.id.req);
        en=findViewById(R.id.en);

    }
    public void setData()
    {
        String company=(String)getIntent().getExtras().get("company");
        String imglogo=getIntent().getExtras().getString("logo");
        String jobtitle=getIntent().getExtras().getString("title");

        String jobbdesc=getIntent().getExtras().getString("description");
        String end=getIntent().getExtras().getString("end");
        end="closing "+end;

        jbber.setText(jobbdesc);
        GlideApp.with(this).load(imglogo).transform(new CenterCrop(),new RoundedCorners(16)).into(logoo);
        company_name.setText(company);
        en.setText(end);


    }
}
