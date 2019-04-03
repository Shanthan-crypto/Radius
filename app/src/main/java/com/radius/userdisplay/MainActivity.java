package com.radius.userdisplay;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static public TextView userView;
    static public Button refreshBtn;
    static public ListView userList;
    static public ImageView imgView;

    static public ProgressDialog progressDialog;

    static public ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshBtn = findViewById(R.id.getDataButton);
        progressDialog=new ProgressDialog(this);

        userArrayList = new ArrayList<User>();
        userList = findViewById(R.id.list);
        imgView =findViewById(R.id.thumbImage);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch();

            }
        });


    }
    private void fetch(){
        fetchUser process = new fetchUser(MainActivity.this);
        process.execute();
        progressDialog.setMessage("Fetching Data");
        progressDialog.show();
    }
}
