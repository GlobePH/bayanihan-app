package com.wanderast.bayanihan.util;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wanderast.bayanihan.R;
import com.wanderast.bayanihan.model.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    List<Person> persons = new ArrayList<>();

    public PersonAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        persons = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.template_person, null);

        Person person = persons.get(position);

        TextView author = (TextView) view.findViewById(R.id.name);
        author.setText(person.message);

        TextView location = (TextView) view.findViewById(R.id.location);
        location.setText(person.friendlyDate);

        ImageView avatar = (ImageView) view.findViewById(R.id.avatar);
        if(person.category.equals("minor")) {
            avatar.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_green));
        } else if(person.category.equals("major")) {
            avatar.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_yellow));
        } else {
            avatar.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_red));
        }


        return view;
    }
}
