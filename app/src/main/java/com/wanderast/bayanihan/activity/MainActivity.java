package com.wanderast.bayanihan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.wanderast.bayanihan.R;
import com.wanderast.bayanihan.model.Person;
import com.wanderast.bayanihan.util.PersonAdapter;
import com.wanderast.bayanihan.util.Rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Switch listToggle;
    TextView helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listToggle = (Switch) findViewById(R.id.list_toggle);
        listView = (ListView) findViewById(R.id.person_list);
        helper = (TextView) findViewById(R.id.helper);

        listToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Thread getList = new Thread(new GetList());
                    getList.start();
                    helper.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                } else {
                    listView.setVisibility(View.GONE);
                    helper.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public class GetList implements Runnable {

        @Override
        public void run() {
            try {
                Call<JsonArray> call = Rest.endpoint().getPersons();
                Response<JsonArray> response = call.execute();
                int statusCode = response.code();
                if(statusCode != 200) {
                    return;
                }
                JsonArray rawPersons = response.body();
                Person.Deserializer dsr  = new Person.Deserializer();
                List<Person> persons = new ArrayList<>();
                for (JsonElement rawPerson:rawPersons) {
                    persons.add(dsr.deserialize(rawPerson.getAsJsonObject(), null, null));
                }
                final PersonAdapter personAdapter = new PersonAdapter(getApplicationContext(), R.layout.template_person, persons);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listView.setAdapter(personAdapter);
                        personAdapter.notifyDataSetChanged();
                    }
                });

            } catch (IOException e) {
                Log.d("ERROR!", e.toString());
                e.printStackTrace();
            }
        }
    }
}