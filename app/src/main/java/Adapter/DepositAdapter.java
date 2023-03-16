package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectprm.R;

import java.math.BigDecimal;
import java.util.Date;
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

        Date date = new Date(depositRequest.getCreated());
        String dateByFormat = "null";
        if (date!= null){
            dateByFormat = date.getDate() + "/" + (date.getMonth()+1) + "/"
                    + (date.getYear()+1900) + " " + date.getHours() + ":" + date.getMinutes()
                    + ":" + date.getSeconds();
        }

        String amount = "null";
        if (depositRequest.getAmount().compareTo(new BigDecimal("0.00")) == 1) {
            amount = depositRequest.getAmount().toString();
        }

        holder.createdDate.setText(dateByFormat);
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
