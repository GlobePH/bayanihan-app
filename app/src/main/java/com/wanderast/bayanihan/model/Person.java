package com.wanderast.bayanihan.model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Date;

public class Person {
    @SerializedName("name")
    public String name;

    @SerializedName("mobileNumber")
    public String mobileNumber;

    @SerializedName("message")
    public String message;

    @SerializedName("timestamp")
    public Date timestamp;

    @SerializedName("category")
    public String category;

    @SerializedName("friendlyDate")
    public String  friendlyDate;


    public static class Builder {
        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setName(String name) {
            person.name = name;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            person.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setMessage(String message) {
            person.message = message;
            return this;
        }

        public Builder setTimestamp(Date timestamp) {
            person.timestamp = timestamp;
            return this;
        }

        public Builder setCategory(String category) {
            person.category = category;
            return this;
        }

        public Builder setFriendlyDate(String friendlyDate) {
            person.friendlyDate = friendlyDate;
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
            return person;
        }
    }
}

