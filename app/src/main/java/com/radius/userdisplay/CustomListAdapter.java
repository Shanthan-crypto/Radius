package com.radius.userdisplay;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<User> {
    ArrayList<User> users;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<User> users) {
        super(context, resource, users);
        this.users = users;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

        }
        User product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
        Picasso.with(context).load(product.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.name);
        txtName.setText(product.getName());


        TextView txtEmail = (TextView) convertView.findViewById(R.id.email);
        txtEmail.setText(product.getEmail());


        TextView txtAge = (TextView) convertView.findViewById(R.id.age);
        txtAge.setText(product.getAge());


        TextView txtGender = (TextView) convertView.findViewById(R.id.gender);
        txtGender.setText(product.getGender());


        ImageView thumbnail = (ImageView) convertView.findViewById(R.id.thumbImage);
        Picasso.with(context).load(product.getImage()).into(imageView);

        return convertView;
    }
}
