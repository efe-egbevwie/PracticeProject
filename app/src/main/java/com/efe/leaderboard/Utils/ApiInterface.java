package com.efe.leaderboard.Utils;

import com.efe.leaderboard.CustomClasses.LearnerObject;
import com.efe.leaderboard.CustomClasses.SkillIqObject;
import com.efe.leaderboard.CustomClasses.SubmitData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("api/hours")
    Call<List<LearnerObject>> getData();

    @GET("/api/skilliq")
    Call<List<SkillIqObject>> getSkillData();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<SubmitData> submit(
            @Field(" entry.1824927963")String Email,
            @Field("entry.1877115667")String Name,
            @Field("entry.2006916086")String LastName,
            @Field("entry.284483984")String link
//
//
    );


}