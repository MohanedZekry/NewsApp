package com.mohaned.androidpaginglibrary.model;

import com.google.gson.annotations.SerializedName;


public class Item {
    @SerializedName("owner")
    private Owner owner;

    @SerializedName("is_accepted")
    private boolean is_accepted;

    @SerializedName("score")
    private int score;

    @SerializedName("last_activity_date")
    private long last_activity_date;

    @SerializedName("creation_date")
    private long creation_date;

    @SerializedName("answer_id")
    private long answer_id;

    @SerializedName("question_id")
    private long question_id;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(long answer_id) {
        this.answer_id = answer_id;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }
}