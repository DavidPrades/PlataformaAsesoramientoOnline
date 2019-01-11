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

public class ImageAdapter extends  RecyclerView.Adapter<ImageAdapter.TarjViewHolder> implements View.OnClickListener{

    private static ArrayList<Image> items;
    private View.OnClickListener listener;

    public ImageAdapter(ArrayList<Image> items) {
        this.items = items;
    }



    public class TarjViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private ImageView image;


        public TarjViewHolder(View itemView) {
            super(itemView);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnLongClickListener(new AdapterView.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    ((AppCompatActivity)v.getContext()).startSupportActionMode(modeCallBack);

                    return true;
                }


            });
            image = (ImageView) itemView.findViewById(R.id.idLogo);

        }
        private ActionMode.Callback modeCallBack = new ActionMode.Callback() {

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
                mode = null;
            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                return true;
            }


        };

        public void bindTitular(Image t) {
            image.setImageResource(t.getTexto());

            final Image image = t;


        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
           // menu.add(0, 0, getAdapterPosition(), "Editar");     //groupId, itemId, order, title

            //menu.add(0, 1, getAdapterPosition(), "Eliminar");

            //menu.add(0, 2, getAdapterPosition(), "Compartir");
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


}