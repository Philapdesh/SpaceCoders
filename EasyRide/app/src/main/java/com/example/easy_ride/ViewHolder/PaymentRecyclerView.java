package com.example.easy_ride.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_ride.Interface.ItemClickListener;
import com.example.easy_ride.R;

public class PaymentRecyclerView extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemClickListener itemClickListener;
    public ImageView photo;
    public Button Other,local;
    public TextView name,surname,amount;
    public PaymentRecyclerView(@NonNull View itemView) {
        super(itemView);
        photo = itemView.findViewById(R.id.CustImage);
        Other = itemView.findViewById(R.id.btnOther);
        local = itemView.findViewById(R.id.btnLocal);
        name = itemView.findViewById(R.id.CustName);
        surname = itemView.findViewById(R.id.CustSurname);
        amount = itemView.findViewById(R.id.CustAmmount);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
