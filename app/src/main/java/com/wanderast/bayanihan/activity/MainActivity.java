package com.wanderast.bayanihan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wanderast.bayanihan.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.person_list);
//
//        try {
//            Call<JsonArray> call = Rest.endpoint().getPersons();
//            Response<JsonArray> response = call.execute();
//            int statusCode = response.code();
//            if(statusCode != 200) {
//                return;
//            }
//            JsonArray rawPersons = response.body();
//            Person.Deserializer dsr  = new Person.Deserializer();
////            List<Person> persons = new ArrayList<>();
////            for (JsonElement rawPerson:rawPersons) {
////                persons.add(dsr.deserialize(rawPerson.getAsJsonObject(), null, null));
////            }
//            PersonAdapter personAdapter = new PersonAdapter(getApplicationContext(), R.layout.template_person, persons);
//            listView.setAdapter(personAdapter);

//        } catch (IOException e) {
//            Log.d("ERROR!", e.toString());
//            e.printStackTrace();
//        }


    }
}