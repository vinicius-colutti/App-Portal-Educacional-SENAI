package br.com.bmnv.portalaluno.app;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static br.com.bmnv.portalaluno.app.R.id.textView_swipe;

/**
 * Created by 16165872 on 27/03/2017.
 */

public class CustomAdapter extends PagerAdapter {

    private int[] imgs = {R.drawable.slider4,R.drawable.slider4};
    private LayoutInflater inflater;
    private Context context;
    public CustomAdapter(Context context){

        this.context = context;

    }


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView tv = (TextView)v.findViewById(textView_swipe);
        img.setImageResource(imgs[position]);

        if(position == 0){
            tv.setText("Alunos do SENAI Jandira desenvolvem APP inovador!");
        }else if(position == 1){
            tv.setText("Alunos do SENAI BARUERI desenvolvem APP inovador!");
        }





        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
