package com.example.tiatwoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tiatwoactivities.MainActivity.EXTRA_MESSAGE;

public class SecondActivity extends AppCompatActivity {

    private TextView text_message, editText_second;
    private Button button_second;

    public static final String EXTRA_REPLY = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_message = findViewById(R.id.text_message);
        editText_second = findViewById(R.id.editText_second);
        button_second = findViewById(R.id.button_second);

        Intent intent = getIntent();
        String userMessage = intent.getStringExtra(EXTRA_MESSAGE);

        text_message.setText(userMessage);
    }

    public void reply(View view) {

        String reply = editText_second.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,i);
        finish();
    }
}
