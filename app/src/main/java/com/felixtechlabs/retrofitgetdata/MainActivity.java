package com.felixtechlabs.retrofitgetdata;

import android.os.Bundle;

import com.felixtechlabs.retrofitgetdata.Adapter.PostsAdapter;
import com.felixtechlabs.retrofitgetdata.api.APIClient;
import com.felixtechlabs.retrofitgetdata.api.JsonPlaceHolder;
import com.felixtechlabs.retrofitgetdata.model.Posts;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Posts> listPosts;
    JsonPlaceHolder apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getRClient().create(JsonPlaceHolder.class);


        fetchPosts();
    }

    private void fetchPosts() {

        Call<List<Posts>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                List<Posts> posts = response.body();

                PostsAdapter postsAdapter = new PostsAdapter(posts, MainActivity.this);

                RecyclerView recyclerView = findViewById(R.id.rv);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                recyclerView.setAdapter(postsAdapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }


}
