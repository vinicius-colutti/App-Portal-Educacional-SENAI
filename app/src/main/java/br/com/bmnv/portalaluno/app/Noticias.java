package br.com.bmnv.portalaluno.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Noticias extends Fragment {

    CustomAdapter adapter;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.noticias, container, false);

        viewPager =(ViewPager) rootView.findViewById(R.id.view_pager);
        adapter = new CustomAdapter(getContext());
        viewPager.setAdapter(adapter);


        return rootView;



    }

}
