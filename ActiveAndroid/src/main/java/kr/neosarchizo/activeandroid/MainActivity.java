package kr.neosarchizo.activeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Category restaurants = new Category();
        restaurants.name = "Restaurants";
        restaurants.save();

        Item item = new Item();
        item.category = restaurants;
        item.name = "Outback Steakhouse";
        item.save();

        item = new Item();
        item.category = restaurants;
        item.name = "Olive Garden";
        item.save();

        List<Item> items = new Select().from(Item.class).execute();
        for (Item i : items)
            Log.d("NEOSARCHIZO", "Item : "+ i.name + " ("+ i.category.name + ")");

        new Delete().from(Item.class).execute();
    }
}