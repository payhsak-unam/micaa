package com.example.mica;

import RVS.ScholarAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import interfacess.Scholaritem_clicklistener;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.mica.Model.Scholar;
import com.example.mica.recyclerview.CustomItemAnimator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ScholarActivity extends AppCompatActivity implements Scholaritem_clicklistener {

    private RecyclerView rvintern;
    private List mdata;
    private ScholarAdapter scholarAdapter;

    private DocumentReference docref= FirebaseFirestore.getInstance().document("Nit/Home/Career/Scholarship");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholar);

        initViews();
        initmatainterns();
        setUpInternAdapter();
    }

    private void setUpInternAdapter()
    {
        scholarAdapter=new ScholarAdapter(mdata,this);
        rvintern.setAdapter(scholarAdapter);
    }
    private void initmatainterns()
    {
        mdata=new ArrayList<>();

        docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String s =document.getString("comp");
                        String[] s1=s.split(",");

                        String[] s2=document.getString("scholartitle").split(",");
                        String[] s3=document.getString("imgurl").split(",");
                        String[] s4=document.getString("ratings").split(",");
                        String[] s5=document.getString("desc").split(",");
                        String[] s6=document.getString("draw").split(",");
                        for(int i=0;i<s1.length;i++)
                        {
                            mdata.add(new Scholar(s1[i],s2[i],s3[i],Integer.parseInt(s4[i]),4.1f,s6[i],s5[i]));
                        }
                        scholarAdapter.notifyDataSetChanged();
//                        String g=document.getString("aaa");
//                        System.out.println("kashit"+g+s[0]);

                    } else {
                        Log.d("tag", "No such document");
                    }
                } else {
                    Log.d("tag", "get failed with ", task.getException());
                }
            }
        });

       // int x=R.drawable.apple_logo;
     //   System.out.println("Amazon"+R.drawable.amazon+"apple"+x+"Coca"+R.drawable.coca+"Google"+R.drawable.google+"NASA"+R.drawable.nasa);

    }
    private void initViews()
    {

        rvintern=findViewById(R.id.rvintern);
        rvintern.setLayoutManager(new LinearLayoutManager(this));
        rvintern.setHasFixedSize(true);

        rvintern.setItemAnimator(new CustomItemAnimator());


    }

    @Override
    public void onScholarClick(Scholar scholar, ImageView scholarlog) {
        Intent intent=new Intent(this,JobDetailsinfo.class);


        //    startActivity(intent);
        System.out.println(scholar.getDescription());
        intent.putExtra("company",scholar.getCompany());
        intent.putExtra("logo",scholar.getDrawableResources());
        intent.putExtra("title",scholar.getJob());
        intent.putExtra("description",scholar.getDescription());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(ScholarActivity.this,scholarlog,"sharedpic");

        startActivity(intent,options.toBundle());
    }
}
