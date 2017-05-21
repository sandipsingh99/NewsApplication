package com.cegepgim.group.newsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EntertainNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertain_news);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Entertain");


        myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for(DataSnapshot child : dataSnapshot.getChildren())
                {

                    String News=child.child("News4").getValue(String.class);
                    String News2=child.child("News5").getValue(String.class);
                    String News3=child.child("News6").getValue(String.class);

                    Toast.makeText(EntertainNews.this,"getting data from firebase", Toast.LENGTH_SHORT).show();


                    TextView textView1=(TextView) findViewById(R.id.textView4);
                    textView1.setText(News);

                    TextView textView2=
                    textView2.setText(News2);

                    TextView textView3=
                    textView3.setText(News3);

                }
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                Toast.makeText(EntertainNews.this, "Failed to load value", Toast.LENGTH_SHORT).show();
            }
        });
    }




}













