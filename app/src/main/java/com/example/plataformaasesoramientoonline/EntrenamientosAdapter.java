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

    private static ArrayList<Image> items;
    private View.OnClickListener listener;

    public EntrenamientosAdapter(ArrayList<Image> items) {
        this.items = items;
    }


    public class TarjViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView precio;
        private TextView descripcion;
        private Button button;


        public TarjViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.idNombre);
            precio= (TextView) itemView.findViewById(R.id.textViewSitio);
            descripcion  = (TextView) itemView.findViewById(R.id.textViewPunt);
            
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                    puntuacion.setText(""+rating);
                }
            });
        }

        public void bindTitular(Image t) {

            // Ara és un byte[] no un int
            byte [] img = t.getImage();
            Bitmap imgBmp = BitmapFactory.decodeByteArray(img,0,img.length);
            image.setImageBitmap(imgBmp);
            idNombre.setText(t.getNombre());
            textView3.setText(t.getCalle());



                }
        }


    @Override
    public TarjViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        itemView.setOnClickListener(this);
        TarjViewHolder tvh = new TarjViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.TarjViewHolder tarjViewHolder, int i) {
        Image item = items.get(i);
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