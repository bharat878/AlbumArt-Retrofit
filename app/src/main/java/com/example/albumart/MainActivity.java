package com.example.albumart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.albumart.adapter.AlbumAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   // private TextView textView;
    public static Retrofit retrofit;

    private RecyclerView mRecyclerView;
    private ArrayList<Post> mPost;
    private AlbumAdapter mAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

      //  textView = findViewById(R.id.textView);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPost = new ArrayList<>();

         retrofit = new Retrofit.Builder()
                 .baseUrl("http://rallycoding.herokuapp.com/api/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

         JsonPlaceHolderApii jsonPlaceHolderApii = retrofit.create(JsonPlaceHolderApii.class);
        Call<List<Post>> call =jsonPlaceHolderApii.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    //textView.setText("code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post: posts){
                    String title = post.getTitle();
                    String artist = post.getArtist();
                    String url = post.getUrl();
                    String image = post.getImageUrl();
                    String thumnailImage = post.getThumbnilImageUrl();

                    mPost.add(new Post(title,artist,url,image,thumnailImage));
                }

                mAlbumAdapter = new AlbumAdapter(MainActivity.this, mPost);
                mRecyclerView.setAdapter(mAlbumAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
              //  textView.setText(t.getMessage());
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
