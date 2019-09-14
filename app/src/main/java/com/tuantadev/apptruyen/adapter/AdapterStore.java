package com.tuantadev.apptruyen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantadev.apptruyen.R;
import com.tuantadev.apptruyen.Inter.IStore;
import com.tuantadev.apptruyen.UI.Store;


public class AdapterStore extends RecyclerView.Adapter<AdapterStore.StoreViewHolder>{
    private IStore inter;

    public AdapterStore(IStore inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).
            inflate(R.layout.item_store,viewGroup,false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreViewHolder storeViewHolder, int i) {
        Store store=inter.getStore(i);
        storeViewHolder.tvName.setText(store.getName());
        storeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClick(storeViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView title;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_store);
        }
    }
}
