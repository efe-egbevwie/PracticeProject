package com.efe.leaderboard.CustomClasses;

import com.google.gson.annotations.SerializedName;

public class LearnerObject {
    @SerializedName("name")
    String learnerName;
    @SerializedName("hours")
    String learningHours;
    @SerializedName("country")
    String learnerLocation;
    String learningHoursText;
    int badge;

    public LearnerObject(String learnerName, String learningHours, String learnerLocation) {
        this.learnerName = learnerName;
        this.learningHours = learningHours;
        this.learnerLocation = learnerLocation;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public String getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(String learningHours) {
        this.learningHours = learningHours;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public String getLearnerLocation() {
        return learnerLocation;
    }

    public String getLearningHoursText() {
        return learningHoursText;
    }

    public void setLearningHoursText(String learningHoursText) {
        this.learningHoursText = learningHoursText;
    }

    public void setLearnerLocation(String learnerLocation) {
        this.learnerLocation = learnerLocation;
    }
}
