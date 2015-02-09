package com.bignerdranch.android.clickerquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Rami on 2/7/2015.
 */

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class StudentsPage extends Activity {

    private Button mA;
    private Button mB;
    private Button mC;
    private Button mD;
    private Button mE;
    private TextView mQ;
    private Button mHome;
    private int[] numbers = {
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        mHome = (Button) findViewById(R.id.home);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentsPage.this, MainActivity.class);
                startActivity(i);
            }
        });

        mA = (Button)findViewById(R.id.button_a);
        mB = (Button)findViewById(R.id.button_b);
        mC = (Button)findViewById(R.id.button_c);
        mD = (Button)findViewById(R.id.button_d);
        mE = (Button)findViewById(R.id.button_e);
        mQ = (TextView)findViewById(R.id.question);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
        query.addDescendingOrder("createdAt");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (object == null) {
                    Log.d("score", "The getFirst request failed.");
                } else {
                    Log.d("score", "Retrieved the object.");
                    mA.setText("A.) " + object.getString("Answer_1"));
                    mB.setText("B.) " + object.getString("Answer_2"));
                    mC.setText("C.) " + object.getString("Answer_3"));
                    mD.setText("D.) " + object.getString("Answer_4"));
                    mE.setText("E.) " + object.getString("Answer_5"));
                    mQ.setText(object.getString("Main_Question"));

                    final String real = object.getString("Real_Answer");
                    final ParseObject answers = new ParseObject("Answers");

                    mA = (Button) findViewById(R.id.button_a);
                    mA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            numbers[0]++;
                            answers.put("A", numbers[0]);
                            answers.saveInBackground();
                            if (real.equals("Answer 1")){
                                numbers[1]++;
                                answers.put("AmountCorrect", numbers[1]);
                                answers.saveInBackground();
                            }
                        }
                    });
                    mB = (Button) findViewById(R.id.button_b);
                    mB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            numbers[2]++;
                            answers.put("B", numbers[2]);
                            answers.saveInBackground();
                            if (real.equals("Answer 2")){
                                numbers[3]++;
                                answers.put("AmountCorrect", numbers[3]);
                                answers.saveInBackground();
                            }
                        }
                    });
                    mC = (Button) findViewById(R.id.button_c);
                    mC.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            numbers[4]++;
                            answers.put("C", numbers[4]);
                            answers.saveInBackground();
                            if (real.equals("Answer 3")){
                                numbers[5]++;
                                answers.put("AmountCorrect", numbers[5]);
                                answers.saveInBackground();
                            }
                        }
                    });
                    mD = (Button) findViewById(R.id.button_d);
                    mD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            numbers[6]++;
                            answers.put("D", numbers[6]);
                            answers.saveInBackground();
                            if (real.equals("Answer 4")){
                                numbers[7]++;
                                answers.put("AmountCorrect", numbers[7]);
                                answers.saveInBackground();
                            }
                        }
                    });
                    mE = (Button) findViewById(R.id.button_e);
                    mE.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            numbers[8]++;
                            answers.put("E", numbers[8]);
                            answers.saveInBackground();
                            if (real.equals("Answer 5")){
                                numbers[9]++;
                                answers.put("AmountCorrect", numbers[9]);
                                answers.saveInBackground();
                            }
                        }
                    });
                }
            }
        });
    }
}
