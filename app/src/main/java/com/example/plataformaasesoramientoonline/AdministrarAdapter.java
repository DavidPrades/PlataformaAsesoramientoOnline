package com.example.plataformaasesoramientoonline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdministrarAdapter extends  RecyclerView.Adapter<AdministrarAdapter.TarjViewHolder> implements View.OnClickListener{

    private static ArrayList<Administrar> items;
    private View.OnClickListener listener;
    private Context context;

    public AdministrarAdapter(ArrayList<Administrar> items) {
        this.items = items;
    }


    public class TarjViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;


        public TarjViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.idLogoAdmin);
            textView = (TextView) itemView.findViewById(R.id.textViewAdmin);

        }

        public void bindTitular(Administrar t) {

            Bitmap bm = BitmapFactory.decodeResource(itemView.getContext().getResources(), t.getLogo());
            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), bm);
            drawable.setCircular(true);
            imageView.setImageDrawable(drawable);
            textView.setText(t.getTexto());

        }
    }

        @Override
        public TarjViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_itemadministrar, viewGroup, false);
            itemView.setOnClickListener(this);
            TarjViewHolder tvh = new TarjViewHolder(itemView);
            return tvh;
        }

        @Override
        public void onBindViewHolder(@NonNull AdministrarAdapter.TarjViewHolder tarjViewHolder, int i) {
            Administrar item = items.get(i);
            tarjViewHolder.bindTitular(item);

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void setOnClickListener(View.OnClickListener listener){
            this.listener=listener;
        }
        @Override
        public void onClick(View v) {

            if (listener != null){
                listener.onClick(v);
            }
        }
}