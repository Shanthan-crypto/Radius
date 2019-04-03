package com.radius.userdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static public TextView userView;
    static public Button refreshBtn;
    static public ListView userList;

    static public ArrayList<HashMap<String,String>> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshBtn = findViewById(R.id.getDataButton);

        userArrayList = new ArrayList<>();
        userList = findViewById(R.id.list);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchUser process = new fetchUser(MainActivity.this);
                process.execute();
            }
        });
    }
}
