package com.example.mica;

import RVS.InternAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import interfacess.Internitem_clicklistener;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mica.Model.Intern;
import com.example.mica.recyclerview.CustomItemAnimator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class InternActivity extends AppCompatActivity implements Internitem_clicklistener {

    private RecyclerView rvintern;
    private List mdata;
    private InternAdapter internAdapter;

    private DocumentReference docref= FirebaseFirestore.getInstance().document("Nit/Home/Career/Interns");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern);

        initViews();
        initmatainterns();
        setUpInternAdapter();

    }
    private void setUpInternAdapter()
    {
        internAdapter=new InternAdapter(mdata,this);
        rvintern.setAdapter(internAdapter);
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

                        String[] s2=document.getString("interntitle").split(",");
                        String[] s3=document.getString("imgurl").split(",");
                        String[] s4=document.getString("ratings").split(",");
                        String[] s5=document.getString("desc").split(",");
                        String[] s6=document.getString("draw").split(",");
                        for(int i=0;i<s1.length;i++)
                        {
                            mdata.add(new Intern(s1[i],s2[i],s3[i],Integer.parseInt(s4[i]),4.1f,s6[i],s5[i]));
                        }
                        internAdapter.notifyDataSetChanged();
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

        int x=R.drawable.apple_logo;
        System.out.println("Amazon"+R.drawable.amazon+"apple"+x+"Coca"+R.drawable.coca+"Google"+R.drawable.google+"NASA"+R.drawable.nasa);

    }
    private void initViews()
    {

        rvintern=findViewById(R.id.rvintern);
        rvintern.setLayoutManager(new LinearLayoutManager(this));
        rvintern.setHasFixedSize(true);

        rvintern.setItemAnimator(new CustomItemAnimator());


    }

    @Override
    public void onInternClick(Intern intern, ImageView internlog) {
        Intent intent=new Intent(this,JobDetailsinfo.class);


        //    startActivity(intent);
        System.out.println(intern.getDescription());
        intent.putExtra("company",intern.getCompany());
        intent.putExtra("logo",intern.getDrawableResources());
        intent.putExtra("title",intern.getJob());
        intent.putExtra("description",intern.getDescription());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(InternActivity.this,internlog,"sharedpic");

        startActivity(intent,options.toBundle());
      //  Toast.makeText(this,intern.getCompany(),Toast.LENGTH_SHORT).show();
    }
}
