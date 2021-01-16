package com.example.hasilbola_0129;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MatchResponse {
    @SerializedName("events")
    private ArrayList<Match> events;

    public ArrayList<Match> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Match> results) {
        this.events = events;
    }


}


