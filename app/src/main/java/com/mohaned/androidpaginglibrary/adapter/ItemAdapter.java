package com.mohaned.androidpaginglibrary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mohaned.androidpaginglibrary.R;
import com.mohaned.androidpaginglibrary.model.Item;

public class ItemAdapter extends PagedListAdapter<Item, ItemAdapter.ItemViewHolder> {

    Context mContext;

    public ItemAdapter(Context mContext) {
        super(diffCallback);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = getItem(position);
        if (item != null){
            Glide.with(mContext).load(item.getOwner().getProfile_image())
                    .into(holder.imageView);
            holder.textView.setText(item.getOwner().getDisplay_name());
        }
        else {
            Toast.makeText(mContext, "Empty Item", Toast.LENGTH_SHORT).show();
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    private static DiffUtil.ItemCallback<Item> diffCallback = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getAnswer_id() == newItem.getAnswer_id();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Item oldItem,  Item newItem) {
            return oldItem.equals(newItem);
        }
    };

}
