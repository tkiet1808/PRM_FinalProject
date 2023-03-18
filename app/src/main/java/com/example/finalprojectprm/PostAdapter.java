package com.example.finalprojectprm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context mContext;
    private List<PostRequest> mlist;

    public PostAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setPostData(List<PostRequest> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        PostRequest postRequest = mlist.get(position);
        if (postRequest == null) {
            return;
        }
//        String[] dateString = postRequest.getCreated().toString().split("");
//        String date = "";
//        for (int i = 0; i <= 18; i++) {
//            date += dateString[i];
//        }


//        String price = postRequest.getPrice().toString();

//        holder.createdDate.setText("date");
//        holder.price.setText("price");
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView createdDate;
        public TextView price;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            createdDate = itemView.findViewById(R.id.createdDate_field);
            price = itemView.findViewById(R.id.amount_field);
        }
    }
}
