package com.example.tiatwoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.tiatwoactivities.SecondActivity.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity {

    private EditText messageEditText;
    private TextView text_header_reply, text_message_reply;
    public static final String EXTRA_MESSAGE = "MESSAGE";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.editText_main);
        text_header_reply = findViewById(R.id.text_header_reply);
        text_message_reply = findViewById(R.id.text_message_reply);

    }

    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        String userMessage = messageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, userMessage);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                text_header_reply.setVisibility(View.VISIBLE);
                String reply = data.getStringExtra(EXTRA_REPLY);
                text_message_reply.setText(reply);
                text_message_reply.setVisibility(View.VISIBLE);

            }

        }
    }
}
