package com.felixtechlabs.retrofitgetdata.api;

import com.felixtechlabs.retrofitgetdata.model.Comments;
import com.felixtechlabs.retrofitgetdata.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Posts>> getPosts();

    @GET("comments")
    Call<List<Comments>> getComments(@Query("postId") int id);


}
