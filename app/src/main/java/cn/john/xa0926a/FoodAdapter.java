package cn.john.xa0926a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by john on 2018/9/26.
 */

public class FoodAdapter extends ArrayAdapter<Food> {

    private List<Food> data;

    public FoodAdapter(Context context, int resource, List<Food> data){
        super(context,resource,data);
        this.data=data;
    }
    @Override
    public int getCount() {

        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater
                .from(getContext())
                .inflate(R.layout.food_layout,parent,false);
        Food f= data.get(position);
        Log.i("john",f.getClass().getName());

        TextView nametv=view.findViewById(R.id.foodName);
        TextView pricetv=view.findViewById(R.id.foodPrice);
        nametv.setText(f.getName());
        pricetv.setText(f.getPrice()+"");
        return  view;
    }
}
