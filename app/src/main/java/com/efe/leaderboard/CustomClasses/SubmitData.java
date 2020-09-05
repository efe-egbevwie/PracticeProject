package com.efe.leaderboard.CustomClasses;

import com.google.gson.annotations.SerializedName;

public class SubmitData {
    @SerializedName("Email Address")
    public String email;
    @SerializedName("Name")
    public String name;
    @SerializedName("Last name")
    public String lastName;
    @SerializedName("Link to project")
    public String projectLink;

    public SubmitData(String email, String name, String lastName, String projectLink) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.projectLink = projectLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
