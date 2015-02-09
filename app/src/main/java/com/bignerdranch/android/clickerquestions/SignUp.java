package com.bignerdranch.android.clickerquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Rami on 2/7/2015.
 */
public class SignUp extends Activity implements AdapterView.OnItemSelectedListener {

    private String mUsername;
    private String mPassword;
    private String mPassword2;
    private Button mFinish;
    private Button mHome;
    private RadioGroup mOccupation;
    private RadioButton mChoice;
    boolean Student = true  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //mOccupation = (RadioGroup)findViewById(R.id.occupation);

        Spinner spinner = (Spinner) findViewById(R.id.occu);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.occupation, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mHome = (Button) findViewById(R.id.home);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
            }
         });

        mFinish = (Button) findViewById(R.id.finish_button);
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText mUsername = (EditText) findViewById(R.id.user_enter);
                EditText mPassword = (EditText) findViewById(R.id.pass_enter);
                final String username = mUsername.getText().toString();
                final String password = mPassword.getText().toString();
                ParseUser user = new ParseUser();
                user.setUsername(username);
                Log.d("test", username);
                user.setPassword(password);
                Log.d("test", password);
                user.put("Student", Student);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Intent i = new Intent(SignUp.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });

            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        String x = parent.getItemAtPosition(pos).toString();
        if (x.equals("Teacher")){
            Student = false;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



    }
