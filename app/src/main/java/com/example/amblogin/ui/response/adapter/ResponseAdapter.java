package com.example.amblogin.ui.response.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amblogin.R;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>{

    private Context context;
    private ArrayList<ReponseModel> container;

    public ResponseAdapter(Context context) {
        this.context = context;
        this.container = new ArrayList<>();
    }

    public void setData(ArrayList<ReponseModel> models){
        this.container.addAll(models);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ResponseViewHolder(inflater.inflate(R.layout.driver_replay, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseViewHolder holder, int position) {
        holder.profileid.setText(container.get(position).getProfileId());
        holder.message.setText(container.get(position).getMessage());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public class ResponseViewHolder extends RecyclerView.ViewHolder{

        private TextView profileid, message;
        private LinearLayout layout;

        public ResponseViewHolder(@NonNull View itemView) {
            super(itemView);
            profileid = itemView.findViewById(R.id.driver_text_view_profile_id);
            message = itemView.findViewById(R.id.driver_text_view_description_id);
            layout = itemView.findViewById(R.id.driver_linier_layout_id);
        }
    }
}
