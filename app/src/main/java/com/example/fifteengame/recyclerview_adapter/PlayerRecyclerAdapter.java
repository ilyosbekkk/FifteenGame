package com.example.fifteengame.recyclerview_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fifteengame.R;
import com.example.fifteengame.models.Player;

import java.util.ArrayList;

public class PlayerRecyclerAdapter extends RecyclerView.Adapter<PlayerRecyclerAdapter.ViewHolder> {


    //region vars&const
    private ArrayList<Player> mPlayer;


    public PlayerRecyclerAdapter(ArrayList<Player> players) {
        this.mPlayer = players;
    }
    //endregion


    ///region overrides
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.username.setText(mPlayer.get(position).getUserName());
        holder.score.setText(mPlayer.get(position).getTime());

    }

    @Override
    public int getItemCount() {
       return mPlayer.size();
    }
    //endregion

    //region viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView username, score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            score = itemView.findViewById(R.id.score);

        }
    }
//endregion

}

