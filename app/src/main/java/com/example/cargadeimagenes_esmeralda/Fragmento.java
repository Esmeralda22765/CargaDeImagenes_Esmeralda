package com.example.cargadeimagenes_esmeralda;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento extends Fragment {

    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private GridLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragmento, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        adaptador = new Adaptador(getActivity(), MainActivity.getterYSetterHeroeArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptador);
        return v;
    }

}