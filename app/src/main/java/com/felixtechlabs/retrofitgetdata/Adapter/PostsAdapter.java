package com.felixtechlabs.retrofitgetdata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felixtechlabs.retrofitgetdata.DetailActivity;
import com.felixtechlabs.retrofitgetdata.R;
import com.felixtechlabs.retrofitgetdata.model.Posts;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    List<Posts> posts;
    Context context;

    public PostsAdapter(List<Posts> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_design, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(v);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Posts post = posts.get(position);
        String img = "https://source.unsplash.com/random/" + post.getId();
        post.setmImages(img);
        holder.d_user_name.setText(post.getTitle());
        holder.d_user_email.setText(post.getBody());

        Glide.with(context)
                .load(post.getmImages())
                .centerCrop()
                .into(holder.d_profile_pic);

        Glide.with(context)
                .load(post.getmImages())
                .centerCrop()
                .into(holder.d_post_pic);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Id", post.getId());
                // intent.putExtra("Body", post.getBody());
                intent.putExtra("Img", post.getmImages());
                Log.d("in adp", post.getId() + "");

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView d_user_name, d_user_email;
        ImageView d_profile_pic, d_post_pic;
        LinearLayout parentLayout;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            d_profile_pic = itemView.findViewById(R.id.d_profile_pic);
            d_user_name = itemView.findViewById(R.id.d_user_name);
            d_user_email = itemView.findViewById(R.id.d_user_email);
            d_post_pic = itemView.findViewById(R.id.img2);
            parentLayout = itemView.findViewById(R.id.linear_layout);
        }
    }

}
