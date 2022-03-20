package com.example.huawei_intern_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,age,bio,phone;
    Spinner LocSpin;
    int age1;
    String nameS,ageS,bioS,phoneS,locS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting hold of the edit texts in the layout
        name = (EditText) findViewById(R.id.nameET);
        age = (EditText) findViewById(R.id.AgeET);
        phone = (EditText) findViewById(R.id.PhoneET);
        bio = (EditText) findViewById(R.id.BioET);
        LocSpin = (Spinner) findViewById(R.id.LOCSp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.location_element,R.layout.support_simple_spinner_dropdown_item);
        LocSpin.setAdapter(adapter);


    }

   public void SubmitFunc(View view) {
       //getting the user input;
       nameS = name.getText().toString();
       ageS = age.getText().toString();
       age1 =Integer.parseInt(ageS);
       phoneS = phone.getText().toString();
       bioS = bio.getText().toString();
       locS=LocSpin.getSelectedItem().toString();
       //checking if any empty field is present and sending Intent if not

       if (!(nameS.equals("")||ageS.equals("")||age1>100||phoneS.equals("")||bioS.equals(""))) {
           Toast.makeText(MainActivity.this,locS, Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(this,Second.class);
           intent.putExtra("Name",nameS);
           intent.putExtra("Phone",phoneS);
           intent.putExtra("Location",locS);
           intent.putExtra("Age",ageS);
           intent.putExtra("Bio",bioS);
           startActivity(intent);
       }
       if(bioS.equals(""))
       {
           Toast.makeText(MainActivity.this, "Enter a SHORT BIO", Toast.LENGTH_SHORT).show();
           bio.requestFocus();
       }
       if(ageS.equals("")|| age1>100)
       {
           Toast.makeText(MainActivity.this, "Enter the valid AGE", Toast.LENGTH_SHORT).show();
           age.requestFocus();
       }
       if(phoneS.equals(""))
       {
           Toast.makeText(MainActivity.this, "Enter the PHONE_NO", Toast.LENGTH_SHORT).show();
           phone.requestFocus();
       }
       if(nameS.equals(""))
       {
           Toast.makeText(MainActivity.this, "Enter the NAME", Toast.LENGTH_SHORT).show();
           name.requestFocus();
       }

   }

    public void CLearFunc(View view) {
        name.setText("");
        age.setText("");
        phone.setText("");
        bio.setText("");
        name.requestFocus();
    }
}