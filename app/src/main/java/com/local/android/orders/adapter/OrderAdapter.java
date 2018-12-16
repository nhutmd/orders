package com.local.android.orders.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.local.android.orders.R;
import com.local.android.orders.handler.ItemClickListener;
import com.local.android.orders.model.Order;
import com.squareup.picasso.Picasso;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> dataModel;
    private Context context;
    private final ItemClickListener listener;
    private int lastPosition = -1;
    private View view;

    public OrderAdapter(Context context, List<Order> dataModel, ItemClickListener listener) {
        this.context = context;
        this.dataModel = dataModel;
        this.listener = listener;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_order, parent, false);
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        view.startAnimation(animation);
        lastPosition = position;
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OrderViewHolder holder, int position) {
        holder.txtCode.setText(dataModel.get(position).getCode());
        holder.txtTitle.setText(dataModel.get(position).getTitle());
        holder.txtPrice.setText(dataModel.get(position).getPrice());
        holder.txtContent.setText(dataModel.get(position).getContent());
        holder.txtAddressFrom.setText(dataModel.get(position).getAddressFrom());
        holder.txtAddressTo.setText(dataModel.get(position).getAddressTo());
        holder.txtDate.setText(dataModel.get(position).getDate());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataModel.get(position).getImage())
                .placeholder((R.drawable.logo))
                .error(R.drawable.logo)
                .into(holder.image);
        final Order data = dataModel.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data.getCode());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {

        public final View view;

        TextView txtCode;
        TextView txtTitle;
        TextView txtPrice;
        TextView txtContent;
        TextView txtAddressFrom;
        TextView txtAddressTo;
        TextView txtDate;
        ImageView image;

        OrderViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtCode = view.findViewById(R.id.item_order_code);
            txtTitle = view.findViewById(R.id.item_order_title);
            txtPrice = view.findViewById(R.id.item_order_price);
            txtContent = view.findViewById(R.id.item_order_content);
            txtAddressFrom = view.findViewById(R.id.item_order_address_from);
            txtAddressTo = view.findViewById(R.id.item_order_address_to);
            txtDate = view.findViewById(R.id.item_order_date);
            image = view.findViewById(R.id.item_order_img);
        }
    }
}
