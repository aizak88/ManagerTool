package com.example.managertool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
       private EditText txtStudentName,txtAge,txtPhone ;
       private ListView listView;
       ArrayList<String>listItems;
       ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStudentName = findViewById(R.id.txtStudentName);
        txtAge = findViewById(R.id.txtAge);
        txtPhone = findViewById(R.id.txtPhone);
        txtPhone = findViewById(R.id.txtEmail);
        listView = findViewById(R.id.listView);


        Button button = findViewById(R.id.btnRefresh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button = findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkClicked();
                refresh();
            }
        });


        listView = findViewById(R.id.listView);

        listItems = new ArrayList<String>();
        adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItems);

        listView.setAdapter(adapter);
    }
    private void onOkClicked(){
        listItems.add(txtStudentName.getText().toString()+" - "+ txtAge.getText());
        adapter.notifyDataSetChanged();
    }
    private void refresh(){
        txtStudentName.getText().clear();
        txtAge.getText().clear();

        txtStudentName.requestFocus();
    }




}
