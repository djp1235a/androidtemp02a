package cn.john.xa0926a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final List<String> data=new ArrayList<String>();
        data.add("abc");
        data.add("bcd");
        data.add("zyx");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);


        ListView lv=findViewById(R.id.lv);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("john",parent.getItemAtPosition(position).toString());
                Log.i("john",data.get(position));
            }
        });

        List<Food> foods=new ArrayList<Food>();
        for (int i = 0; i < 6; i++) {
            Food food=new Food();
            food.setName("name"+i);
            food.setPrice(i);
            foods.add(food);
        }


        ListView foodLv=findViewById(R.id.foodLv);
        FoodAdapter fadapter=new FoodAdapter(this,R.layout.food_layout,foods);
        foodLv.setAdapter(fadapter);
    }
}
