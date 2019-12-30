package com.gauravrai.sampleproject.API.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("todos")
    Call<List<User>> fetchToDoList();

}
