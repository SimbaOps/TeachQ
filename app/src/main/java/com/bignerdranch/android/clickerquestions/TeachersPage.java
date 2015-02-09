package com.bignerdranch.android.clickerquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Rami on 2/7/2015.
 */
public class TeachersPage extends Activity implements AdapterView.OnItemSelectedListener {

    private Button mSend;
    private Button mHome;
    String y;
    private TextView mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        mHome = (Button) findViewById(R.id.home);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeachersPage.this, MainActivity.class);
                startActivity(i);
            }
        });

        mResults = (TextView)findViewById(R.id.results);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Answers");
        query.addDescendingOrder("createdAt");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (object == null) {
                    Log.d("score", "The getFirst request failed.");
                } else {
                    mResults.setText("A.) " + object.get("A") + " B.) " + object.get("B") + " C.) "
                            + object.get("C") + " D.) " + object.get("D") + " E.) " + object.get("E"));
                }
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.correct_answer);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.answers_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mSend = (Button) findViewById(R.id.button_send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        final EditText mainQuestion = (EditText) findViewById(R.id.set_question);
        final EditText Answer1 = (EditText) findViewById(R.id.set_1);
        final EditText Answer2 = (EditText) findViewById(R.id.set_2);
        final EditText Answer3 = (EditText) findViewById(R.id.set_3);
        final EditText Answer4 = (EditText) findViewById(R.id.set_4);
        final EditText Answer5 = (EditText) findViewById(R.id.set_5);

        final String mainQ = mainQuestion.getText().toString();
        final String A1 = Answer1.getText().toString();
        final String A2 = Answer2.getText().toString();
        final String A3 = Answer3.getText().toString();
        final String A4 = Answer4.getText().toString();
        final String A5 = Answer5.getText().toString();

        ParseObject Questions = new ParseObject("Questions");
        Questions.put("Main_Question", mainQ);
        Questions.put("Answer_1", A1);
        Questions.put("Answer_2", A2);
        Questions.put("Answer_3", A3);
        Questions.put("Answer_4", A4);
        Questions.put("Answer_5", A5);
        Questions.put("Real_Answer", y);
        Questions.saveInBackground();
            }
        });

    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        y = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
