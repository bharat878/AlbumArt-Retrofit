package com.example.albumart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.albumart.Post;
import com.example.albumart.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {


    public TextView titleAlbum, artistAlbum, urlAlbum;
    public ImageView imgAlbum, img;

    private Context mContext;
    private ArrayList<Post> mPost;

    public AlbumAdapter(Context mContext, ArrayList<Post> mPost) {
        this.mContext = mContext;
        this.mPost = mPost;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{


        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            titleAlbum = itemView.findViewById(R.id.titleAlbum);
            artistAlbum= itemView.findViewById(R.id.artistalbum);
           // urlAlbum = itemView.findViewById(R.id.url);
            imgAlbum = itemView.findViewById(R.id.imgAlbum);
            img = itemView.findViewById(R.id.img);
        }
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlbumViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Post post = mPost.get(position);

        String mtitle = post.getTitle();
        String mArtist = post.getArtist();
      //  String mUrl = post.getUrl();
        String imageUrl = post.getImageUrl();
        String mImg = post.getImageUrl();

        titleAlbum.setText(mtitle);
        artistAlbum.setText(mArtist);
       // urlAlbum.setText(mUrl);
        Picasso.get().load(imageUrl).fit().centerInside().into(imgAlbum);
        Picasso.get().load(mImg).fit().into(img);
    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }
}
