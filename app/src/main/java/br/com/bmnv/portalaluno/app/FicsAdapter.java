package br.com.bmnv.portalaluno.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16165872 on 10/04/2017.
 */

public class FicsAdapter extends ArrayAdapter<Fics> {

    int resource;
    public FicsAdapter(Context context, int resource, List<Fics> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(resource, null);
        }

        Fics fics = getItem(position);

        if(fics != null){
            TextView nomeCurso = (TextView) v.findViewById(R.id.text_view_fics);
            TextView status = (TextView) v.findViewById(R.id.text_view_acompanhar);

            nomeCurso.setText(fics.getNome());
            status.setText(fics.getStatus());


        }

        return  v;
    }




}
