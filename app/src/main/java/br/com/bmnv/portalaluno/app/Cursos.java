package br.com.bmnv.portalaluno.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Cursos extends Fragment {

    ListView listCursos;
    List<Fics> listaFics = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cursos, container, false);


        //TODO: Puxar os cursos do banco de dados

        listCursos = (ListView) rootView.findViewById(R.id.list_view_fics);

        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));
        listaFics.add(new Fics("Informática","Aberto"));

        FicsAdapter adapter =  new FicsAdapter(
                getActivity(),
                R.layout.list_item_fics_customizado,
                listaFics);

        listCursos.setAdapter(adapter);


        return rootView;
    }

}
