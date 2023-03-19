package Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.finalprojectprm.R;
import com.example.finalprojectprm.ViewMyPostsActivity;
import com.example.finalprojectprm.ViewProfileActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.PostList;

public class PostAdapter_Edit extends RecyclerView.Adapter<PostAdapter_Edit.PostViewHolder> {
    private Context mContext;
    private List<PostList> mlist;

    public PostAdapter_Edit(Context mContext) {
        this.mContext = mContext;
    }
    public void setPostData(List<PostList> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostAdapter_Edit.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostAdapter_Edit.PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter_Edit.PostViewHolder holder, int position) {
        PostList post = mlist.get(position);
        if (post == null) {
            return;
        }

        Picasso.get().load(post.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(holder.itemPostImage);

        holder.itemPostName.setText(post.getName());
        holder.button.setText(post.getPrice().toString());
        holder.description.setText(post.getDescription());
        holder.editButton.setVisibility(View.VISIBLE);
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Edit Post!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), EditPostActivity.class);
                i.putExtra("id",post.getId().toString());
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
        public Button editButton;
        public TextView description;
//        public TextView tagT1;
//        public TextView tagV1;
//        public TextView tagT2;
//        public TextView tagV2;
//        public TextView tagT3;
//        public TextView tagV3;

        public Button button;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            itemPostImage = itemView.findViewById(R.id.item_post_image);
            itemPostName = itemView.findViewById(R.id.item_post_name);
            editButton = itemView.findViewById(R.id.edit_post_button);
            description = itemView.findViewById(R.id.description_post_item);
//            tagT1 = itemView.findViewById(R.id.tag_type1);
//            tagV1 = itemView.findViewById(R.id.tag_value1);
//            tagT2 = itemView.findViewById(R.id.tag_type2);
//            tagV2 = itemView.findViewById(R.id.tag_value2);
//            tagT3 = itemView.findViewById(R.id.tag_type3);
//            tagV3 = itemView.findViewById(R.id.tag_value3);
            button = itemView.findViewById(R.id.button_price);
        }
    }
}
