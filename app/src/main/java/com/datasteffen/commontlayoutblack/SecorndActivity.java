package com.datasteffen.commontlayoutblack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecorndActivity extends AppCompatActivity {

    private Button buttonBack;
    private EditText edittextuserback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secornd);

        edittextuserback = (EditText) findViewById(R.id.editTextUserBack);
        Bundle extra = getIntent().getExtras();
        String userinfo = extra.getString(MainActivity.MESSAGE);

        final TextView textView = (TextView) findViewById(R.id.editTextUserBack);
        textView.setText(userinfo);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // end this activity
                finish();

            }
        });
    }
public final static String FeedBack = "FeedBack";
    @Override
    public void finish() {
        String userBackString = edittextuserback.getText().toString();
        Intent backpack = new Intent();
        backpack.putExtra(FeedBack, userBackString);
        setResult(RESULT_OK,backpack );
        super.finish();
    }
}
