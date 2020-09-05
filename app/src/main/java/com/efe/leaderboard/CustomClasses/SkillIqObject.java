package com.efe.leaderboard.CustomClasses;

import com.google.gson.annotations.SerializedName;

public class SkillIqObject {
    @SerializedName("name")
    String skillIqname;
    @SerializedName("score")
    String score;
    @SerializedName("country")
    String country;
    String badgeUrl;
    String scoreText;

    public SkillIqObject(String skillIqname, String score, String country) {
        this.skillIqname = skillIqname;
        this.score = score;
        this.country = country;
    }

    public String getSkillIqname() {
        return skillIqname;
    }

    public void setSkillIqname(String skillIqname) {
        this.skillIqname = skillIqname;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getScoreText() {
        return scoreText;
    }

    public void setScoreText(String scoreText) {
        this.scoreText = scoreText;
    }
}
