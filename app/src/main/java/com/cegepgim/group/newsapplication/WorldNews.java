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

import static com.cegepgim.group.newsapplication.R.id.email;

public class WorldNews extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_news);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("World");


        myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for(DataSnapshot child : dataSnapshot.getChildren())
                {

                    String news=child.child("News10").getValue(String.class);
                    String news2=child.child("News11").getValue(String.class);
                    String news3=child.child("News12").getValue(String.class);

                    Toast.makeText(WorldNews.this,"getting data from firebase", Toast.LENGTH_SHORT).show();


                    TextView textView1=(TextView) findViewById(R.id.textView4);
                    textView1.setText(News);

                    TextView textView2=(TextView) findViewById(R.id.textView5);
                    textView2.setText(News2);

                    TextView textView3=(TextView) findViewById(R.id.textView6);
                    textView3.setText(News3);

                }
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                Toast.makeText(WorldNews.this, "Failed to load value", Toast.LENGTH_SHORT).show();
            }
        });
    }










    public void backToHome(View view)
    {
        Toast.makeText(this, "Back To Home", Toast.LENGTH_SHORT).show();
        Intent i= new Intent(this,MainActivity.class );
        startActivity(i);
        finish();
    }
}
