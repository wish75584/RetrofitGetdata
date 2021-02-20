package com.felixtechlabs.retrofitgetdata;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felixtechlabs.retrofitgetdata.Adapter.CommentsAdapter;
import com.felixtechlabs.retrofitgetdata.api.APIClient;
import com.felixtechlabs.retrofitgetdata.api.JsonPlaceHolder;
import com.felixtechlabs.retrofitgetdata.model.Comments;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TextView name, email, body;
    private ImageView img;
    JsonPlaceHolder jsonPlaceHolder;
    RecyclerView recyclerView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.name);
        body = findViewById(R.id.body);
        email = findViewById(R.id.email);
        img = findViewById(R.id.img);
        recyclerView = (RecyclerView) findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        jsonPlaceHolder = APIClient.getRClient().create(JsonPlaceHolder.class);
        int ID = getIntent().getIntExtra("Id", 0);
        Log.d("in detail", ID + "");

        final String Img = getIntent().getStringExtra("Img");
        Log.d("in detail", ID + "");


        Glide.with(this)
                .load(Img)
                .centerCrop()
                .into(img);

        fetchComments(ID);
    }

    private void fetchComments(int id) {
        Call<List<Comments>> comments = jsonPlaceHolder.getComments(id);
        comments.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                List<Comments> comments1 = response.body();


                    CommentsAdapter adapter = new CommentsAdapter(DetailActivity.this,comments1);
                    recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }
}
