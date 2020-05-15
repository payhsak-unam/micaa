package com.example.mica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import interfacess.Jobitem_clicklistener;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mica.Model.Job;
import com.example.mica.recyclerview.CustomItemAnimator;
import com.example.mica.recyclerview.JobAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Jobitem_clicklistener {

    private RecyclerView rvjob;
    private JobAdapter jobAdapter;
    private List<Job> mdata;
//    private Button addjb;
//    private Button remjb;

//    private StorageReference mStorageRef;
    private DocumentReference docref= FirebaseFirestore.getInstance().document("Nit/Home/Career/Jobs");
    FirebaseStorage storage=FirebaseStorage.getInstance("gs://micam-70e4c.appspot.com");
    StorageReference ref=storage.getReference();
//    private static final String NAME_KEY="namekey";
//    private static final String ROLL_KEY="rollkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        long t=System.nanoTime();

        initmatajobs();
        long t2=System.nanoTime();
        t2=t2-t;
        System.out.println("time="+t2);
        setUpJobAdapter();
    }
    private void setUpJobAdapter()
    {
        jobAdapter=new JobAdapter(mdata,this);
        rvjob.setAdapter(jobAdapter);
    }
    private void initmatajobs()
    {
        mdata=new ArrayList<>();

//        docref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot document) {
//                if(document.exists())
//                {
//
//                    String s =document.getString("comp");
//                    String[] s1=s.split(",");
//
//                    String[] s2=document.getString("jobtitle").split(",");
//                    String[] s3=document.getString("imgurl").split(",");
//                    String[] s4=document.getString("ratings").split(",");
//                    String[] s5=document.getString("desc").split(",");
//                    String[] s6=document.getString("draw").split(",");
//                    for(int i=0;i<s1.length;i++)
//                    {
//                        mdata.add(new Job(s1[i],s2[i],s3[i],Integer.parseInt(s4[i]),4.1f,Integer.parseInt(s6[i]),s5[i]));
//                    }
//                    jobAdapter.notifyDataSetChanged();
//
//
//                }
//            }

        docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot document=task.getResult();
                    if(document.exists())
                    {
                        String s =document.getString("comp");
                       final String[] s1=s.split(",");

                       final String[] s2=document.getString("jobtitle").split(",");
                       final String[] s3=document.getString("imgurl").split(",");
                       final String[] s4=document.getString("ratings").split(",");
                       final String[] s5=document.getString("desc").split(",");
                       final String[] s6=document.getString("draw").split(",");
                       final String[] s7=document.getString("date1").split(",");
                       final String[] s8=document.getString("date2").split(",");
                     //  final int j=0;
                        for(int i=0;i<s1.length;i++)
                        {
                          //  final int j=i;
                          //  String name=s1[j];
                         //   StorageReference reff=storage.getReference().child(name);
                        //    reff.getBytes(1024*1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                                @Override
//                                public void onSuccess(byte[] bytes) {
//                                    Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
//                                    mdata.add(new Job(s1[j],s2[j],s3[j],Integer.parseInt(s4[j]),4.1f,bitmap,s5[j],s7[j],s8[j]));
//
//                                }
//
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    System.out.println("shit happens");
//                                }
//                            });


                            mdata.add(new Job(s1[i],s2[i],s3[i],Integer.parseInt(s4[i]),4.1f,s6[i],s5[i],s7[i],s8[i]));
                        }
                        jobAdapter.notifyDataSetChanged();
                    }
                }
            }});



       //     int x=R.drawable.apple_logo;
     //  System.out.println("Amazon"+R.drawable.amazon+"apple"+x+"Coca"+R.drawable.coca+"Google"+R.drawable.google+"NASA"+R.drawable.nasa);


    }
    private void initViews()
    {
       // remjb=findViewById(R.id.button2);
        //addjb=findViewById(R.id.button);
        rvjob=findViewById(R.id.rvid);
        rvjob.setLayoutManager(new LinearLayoutManager(this));
        rvjob.setHasFixedSize(true);

        rvjob.setItemAnimator(new CustomItemAnimator());

//        addjb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addJob();
//            }
//        });

//        remjb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                removejob();
//            }
//        });
    }

    private void removejob() {
        if (mdata.size() > 1) {
            mdata.remove(1);
            jobAdapter.notifyItemRemoved(1);
        }
        else
        {
            Toast.makeText(this,"Cannot remove more items",Toast.LENGTH_SHORT).show();
        }
    }
//    private void addJob()
//    {
//        Job job=new Job();
//        mdata.add(1,job);
//        jobAdapter.notifyItemInserted(1);
//    }

    @Override
    public void onJobClick(Job job, ImageView joblog) {

         Intent intent=new Intent(this,JobDetailsinfo.class);


    //    startActivity(intent);
        System.out.println(job.getDescription());
        intent.putExtra("company",job.getCompany());
        intent.putExtra("logo",job.getDrawableResources());
        intent.putExtra("title",job.getJob());
        intent.putExtra("description",job.getDescription());
        intent.putExtra("start",job.getDate1());
        intent.putExtra("end",job.getDate2());
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,joblog,"sharedpic");

        startActivity(intent,options.toBundle());
      //  Toast.makeText(this,job.getCompany(),Toast.LENGTH_SHORT).show();
    }


}
