package com.example.huawei_intern_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    String name,age,location,phone,bio;
    TextView nameT,ageT,locT,phoneT,bioT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameT = (TextView)findViewById(R.id.nameT);
        ageT = (TextView)findViewById(R.id.ageT);
        phoneT = (TextView)findViewById(R.id.phoneT);
        locT = (TextView)findViewById(R.id.locationT);
        bioT = (TextView)findViewById(R.id.bioT);
        Bundle b1 = getIntent().getExtras();
        name = b1.getString("Name");
        age = b1.getString("Age");
        phone = b1.getString("Phone");
        location = b1.getString("Location");
        bio = b1.getString("Bio");
        nameT.setText(name);
        ageT.setText(age);
        phoneT.setText(phone);
        locT.setText(location);
        bioT.setText(bio);



    }
}