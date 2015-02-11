package com.bignerdranch.android.clickerquestions;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class MainActivity extends ActionBarActivity {

    private Button mSignUp;
    private Button mLogIn;
    private EditText mUserName;
    private EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Parse.initialize(this, "8jFTThNslaULaEIC6gUHEyanMD8dgeWsj6rNlRFY", "ZaBYTEHhBxN2RaZi5tkNeedIgq70EislnXfXOWGl");
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        mSignUp = (Button)findViewById(R.id.signup_button);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });





        mLogIn = (Button)findViewById(R.id.login_button);
        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Utils.getStringFromId(MainActivity.this, R.id.user_enter);
                String password = Utils.getStringFromId(MainActivity.this, R.id.pass_enter);
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            if (user.getBoolean("Student") == true) {
                                Intent i = new Intent(MainActivity.this, StudentsPage.class);
                                startActivity(i);
                            } else {
                                Intent i = new Intent(MainActivity.this, TeachersPage.class);
                                startActivity(i);
                            }
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }
                });

            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
