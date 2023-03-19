package Adapter;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.button.setText(post.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView itemPostName;
        public ImageView itemPostImage;
        public TextView tagT1;
        public TextView tagV1;
        public TextView tagT2;
        public TextView tagV2;
        public TextView tagT3;
        public TextView tagV3;

        public Button button;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            itemPostImage = itemView.findViewById(R.id.item_post_image);
            itemPostName = itemView.findViewById(R.id.item_post_name);
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
