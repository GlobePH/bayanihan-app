package com.wanderast.bayanihan.model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.Date;

public class Person {
    @SerializedName("name")
    public String name;

    @SerializedName("phone")
    public Integer phone;


    @SerializedName("action")
    public String action;

    @SerializedName("created_date")
    public Date createdDate;

    @SerializedName("coordinates")
    public Coordinates coordinates;


    public static class Builder {
        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setName(String name) {
            person.name = name;
            return this;
        }

        public Builder setPhone(Integer phone) {
            person.phone = phone;
            return this;
        }

        public Builder setAction(String action) {
            person.action = action;
            return this;
        }

        public Builder setCreatedDate(Date createdDate) {
            person.createdDate = createdDate;
            return this;
        }

        public Person get() {
            return this.person;
        }
    }

    public Person() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static class Deserializer implements JsonDeserializer<Person> {
        public Deserializer() { }

        @Override
        public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if(json == null) { return null; }

            Gson gson = new Gson();
            Person person = gson.fromJson(json, Person.class);
            JsonObject jsonObject = json.getAsJsonObject();

            if (jsonObject.has("coordinates")) {
                JsonElement coordinates = jsonObject.get("coordinates");
                if (coordinates != null && !coordinates.isJsonNull()) {
                    person.coordinates = gson.fromJson(coordinates, Coordinates.class);
                }
            }

            return person;
        }
    }
}

