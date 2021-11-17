package com.example.project_blackmirror;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_blackmirror.ui.main.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> implements Serializable {
    private ArrayList<Room> roomArrayList;
    private OnItemClickListener roomListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        roomListener = listener;
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView roomTypeImageView;
        public TextView roomTextView;

        public RoomViewHolder(@NonNull View itemView, OnItemClickListener listener)
        {
            super(itemView);
            roomTextView = itemView.findViewById(R.id.roomTextView);
            roomTypeImageView = itemView.findViewById(R.id.roomTypeImageView);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                    @Override
                    public void onClick(View v)
                    {
                    if(listener != null)
                    {
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RoomAdapter(ArrayList<Room> roomArrayList)
    {
        this.roomArrayList = roomArrayList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View roomCardViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_cardview, parent, false);
        RoomViewHolder roomVH = new RoomViewHolder(roomCardViews, roomListener);
        return roomVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room currentRoom = roomArrayList.get(position);
        int currentRoomType = currentRoom.getRoomType();

        holder.roomTypeImageView.setImageResource(currentRoom.getRoomImage());
        holder.roomTextView.setText(currentRoom.getRoomName());
    }

    @Override
    public int getItemCount() {
        return roomArrayList.size();
    }
}
