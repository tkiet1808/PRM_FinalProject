package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectprm.R;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import Model.DepositRequest;
import Model.MyApplication;
import Model.Tag;

public class EditTagAdapter extends RecyclerView.Adapter<EditTagAdapter.EditTagViewHolder> {
    private Context mContext;
    private List<Tag> mlist;

    public EditTagAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setTagData(List<Tag> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EditTagAdapter.EditTagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deposit, parent, false);
        return new EditTagAdapter.EditTagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditTagAdapter.EditTagViewHolder holder, int position) {
        Tag tag = mlist.get(position);
        if (tag == null) {
            return;
        }

        holder.key.setText(tag.getType());
        holder.value.setText(tag.getValue());


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class EditTagViewHolder extends RecyclerView.ViewHolder {
        public TextView key;
        public TextView value;

        public EditTagViewHolder(@NonNull View itemView) {
            super(itemView);
            key = itemView.findViewById(R.id.tag_key_edit_tag);
            value = itemView.findViewById(R.id.tag_value_edit_tag);
        }
    }
}
