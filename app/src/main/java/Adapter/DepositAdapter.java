package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectprm.R;
import com.example.finalprojectprm.ViewDepositHistoryActivity;

import java.util.List;

import Model.DepositRequest;

public class DepositAdapter extends RecyclerView.Adapter<DepositAdapter.DepositViewHolder> {
    private Context mContext;
    private List<DepositRequest> mlist;

    public DepositAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDepositData(List<DepositRequest> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DepositAdapter.DepositViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deposit, parent, false);
        return new DepositViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepositAdapter.DepositViewHolder holder, int position) {
        DepositRequest depositRequest = mlist.get(position);
        if (depositRequest == null) {
            return;
        }
        String[] dateString = depositRequest.getCreated().toString().split("");
        String date = "";
        for (int i = 0; i <= 18; i++) {
            date += dateString[i];
        }


        String amount = depositRequest.getAmount().toString();

        holder.createdDate.setText(date);
        holder.amount.setText(amount);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class DepositViewHolder extends RecyclerView.ViewHolder {
        public TextView createdDate;
        public TextView amount;

        public DepositViewHolder(@NonNull View itemView) {
            super(itemView);
            createdDate = itemView.findViewById(R.id.createdDate_field);
            amount = itemView.findViewById(R.id.amount_field);
        }
    }
}
