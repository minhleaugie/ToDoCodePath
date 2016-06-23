package com.example.minhelqueue.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText etSaveItem;
    String string;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String text = getIntent().getStringExtra("text");

        etSaveItem = (EditText) findViewById(R.id.etEditItem);
        etSaveItem.setText("Edit Item Below: \n" + text);
        etSaveItem.setSelection(etSaveItem.getText().length());


        position = getIntent().getIntExtra("position", 0);


    }

    public void onSaveItem(View v) {

        int linenumber = 1;
        int startPos = etSaveItem.getLayout().getLineStart(linenumber);
        int endPos = etSaveItem.getLayout().getLineEnd(linenumber);

        string = etSaveItem.getText().toString().substring(startPos, endPos);

        Intent data = new Intent();
        data.putExtra("text", string);
        data.putExtra("position", position);

        setResult(RESULT_OK, data);
        finish();
    }


}
