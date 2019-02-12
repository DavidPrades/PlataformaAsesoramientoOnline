package com.example.plataformaasesoramientoonline;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class EntrenamientosAdapter extends  RecyclerView.Adapter<EntrenamientosAdapter.TarjViewHolder> implements View.OnClickListener{

    private static ArrayList<Entrenamientos> items;
    private View.OnClickListener listener;

    public EntrenamientosAdapter(ArrayList<Entrenamientos> items) {
        this.items = items;
    }


    public class TarjViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView precio;
        private TextView descripcion;
        private TextView comprar;



        public TarjViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.titulo);
            precio= (TextView) itemView.findViewById(R.id.precio);
            descripcion  = (TextView) itemView.findViewById(R.id.descripcion);
            comprar = itemView.findViewById(R.id.comprar);

        }

        public void bindTitular(Entrenamientos t) {
            titulo.setText(t.getTitulo());
            precio.setText(t.getPrecio());
            descripcion.setText(t.getDescription());
            comprar.setText("COMPRA YA!");

        }
    }


    @Override
    public TarjViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_entrenamientos, viewGroup, false);
        itemView.setOnClickListener(this);
        TarjViewHolder tvh = new TarjViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TarjViewHolder tarjViewHolder, int i) {
        Entrenamientos item = items.get(i);
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

    public int getItemViewPosition(int position) {
        return position;
    }


}