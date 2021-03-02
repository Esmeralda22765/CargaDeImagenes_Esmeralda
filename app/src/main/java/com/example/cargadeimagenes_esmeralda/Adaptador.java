package com.example.cargadeimagenes_esmeralda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {


    ArrayList<GetterYSetterHeroe> getterYSetterHeroeList;
    private Context contexto;
    private LayoutInflater inflater;

    @Override
    public int getItemCount() {
        return getterYSetterHeroeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_view;
        public TextView text_view;

        public ViewHolder(View itemView)
        {
            super(itemView);
            image_view = (ImageView) itemView.findViewById(R.id.image_view);
            text_view = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
    public Adaptador(Context contexto, ArrayList<GetterYSetterHeroe> getterYSetterHeroeList) {
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getterYSetterHeroeList = getterYSetterHeroeList;
        this.contexto = contexto;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.layout_cardview, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetterYSetterHeroe itemimg = getterYSetterHeroeList.get(position);
        Picasso.get().load(itemimg.getImageurl()).into(holder.image_view);
        holder.text_view.setText(itemimg.getTextoIMG());
    }

}
