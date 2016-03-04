package com.datasteffen.commontlayoutblack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserInput;
    private Button buttonToUserInput;
    private Intent intent;
    public final static String MESSAGE = "MESSAGE";
    public final static int REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserInput = (EditText) findViewById(R.id.editTextInput);
        buttonToUserInput = (Button) findViewById(R.id.button);

        buttonToUserInput.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // change to secorndactivity
                intent = new Intent(getBaseContext(),SecorndActivity.class);
               String userType = editTextUserInput.getText().toString();
                intent.putExtra(MESSAGE,userType);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE && resultCode == RESULT_OK){
            String userback = data.getExtras().getString(SecorndActivity.FeedBack);

            editTextUserInput.setText(userback);
        }
    }
}
