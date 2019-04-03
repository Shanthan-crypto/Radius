package com.radius.userdisplay;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class fetchUser extends AsyncTask<Void,Void,Void> {

    private Context context;

    public fetchUser(Context c){
        context = c;
    }

    private String json="";
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        ListAdapter adapter = new SimpleAdapter(context,MainActivity.userArrayList,R.layout.list_item,
                new String[]{"name","gender","email","age","thumbImage"},new int[]{R.id.name,R.id.gender,R.id.email,R.id.age,R.id.thumbImage});

        
        MainActivity.userList.setAdapter(adapter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://raw.githubusercontent.com/iranjith4/radius-intern-mobile/master/users.json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream ipStream = conn.getInputStream();
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(ipStream));
            String line = "";
            while (line!=null){
                line  = buffReader.readLine();
                json = json + line;
            }

            JSONObject jsonObj = new JSONObject(json);
            JSONArray results = jsonObj.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                JSONObject c = results.getJSONObject(i);
                System.out.println(results.getJSONObject(i));
//                Iterator<String> keys = c.keys();
//
//                while(keys.hasNext()){
//
//                    System.out.println(keys.toString());
//                    keys.next();
//                }

                String gender = c.getString("gender");

                String email = c.getString("email");

                // Name node is JSON Object
                JSONObject name = c.getJSONObject("name");
                String title = name.getString("title");
                String first = name.getString("first");
                String last = name.getString("last");

                JSONObject dob = c.getJSONObject("dob");
                String age = dob.getString("age");


                JSONObject images = c.getJSONObject("picture");
                String thumbnailURL = images.getString("thumbnail");


                HashMap<String, String> user = new HashMap<>();

                // adding each child node to HashMap key => value
                user.put("gender", gender);
                user.put("name", title+" "+first+" "+last);
                user.put("email", email);
                user.put("age",age);
                user.put("thumbnailURL",thumbnailURL);

                // adding user to user list

                MainActivity.userArrayList.add(user);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
