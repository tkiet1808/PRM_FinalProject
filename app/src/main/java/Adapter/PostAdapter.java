package Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectprm.EditPostActivity;
import com.example.finalprojectprm.HomeActivity;
import com.example.finalprojectprm.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.PostList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context mContext;
    private List<PostList> mlist;

    public PostAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setPostData(List<PostList> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostAdapter.PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        PostList post = mlist.get(position);
        if (post == null) {
            return;
        }

        Picasso.get().load(post.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(holder.itemPostImage);

        holder.itemPostName.setText(post.getName());
        holder.button.setText(String.valueOf(post.getPrice().intValue()));
        holder.category_name.setText(post.getCategory_name());
        holder.description.setText(post.getDescription());

        holder.add_wish_button.setVisibility(View.VISIBLE);
        holder.add_wish_button.setText("Add to wishlist");
        holder.add_wish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HomeActivity.class);
                i.putExtra("add_wish_id",post.getId().toString());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView itemPostName;
        public ImageView itemPostImage;
        public TextView description;
        public TextView category_name;
        public Button add_wish_button;

        public Button button;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            itemPostImage = itemView.findViewById(R.id.item_post_image);
            itemPostName = itemView.findViewById(R.id.item_post_name);
            description = itemView.findViewById(R.id.description_post_item);
            category_name = itemView.findViewById(R.id.category_name_in_item_post);
            button = itemView.findViewById(R.id.button_price);
            add_wish_button=itemView.findViewById(R.id.post_button_in_item_post);
        }
    }
}
