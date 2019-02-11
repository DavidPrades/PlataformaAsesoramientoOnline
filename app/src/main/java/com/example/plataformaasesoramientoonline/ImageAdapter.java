package com.example.plataformaasesoramientoonline;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageAdapter extends  RecyclerView.Adapter<ImageAdapter.TarjViewHolder>{

    private static ArrayList<Image> items;


    public ImageAdapter(ArrayList<Image> items) {
        this.items = items;
    }



    public class TarjViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private ImageView image;


        public TarjViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.idLogo);

        }


        public void bindTitular(Image t) {
            image.setImageResource(t.getTexto());

            final Image image = t;


        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }



    @Override
    public TarjViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
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



}