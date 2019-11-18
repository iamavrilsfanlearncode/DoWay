package nullteam.com.doway.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;

public class RestaurantDetail extends AppCompatActivity {
    private Restaurant restaurant;
    private TextView tv_Tel,tv_Name,tv_Address,tv_FoodFeature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);

        restaurant = (Restaurant)getIntent().getSerializableExtra("restaurant");
        tv_Tel = findViewById(R.id.Tel);
        tv_Tel.setText(restaurant.getTel());
        tv_Name = findViewById(R.id.Name);
        tv_Name.setText(restaurant.getName());
        tv_Address =findViewById(R.id.Address);
        tv_Address.setText(restaurant.getAddress());
        tv_FoodFeature = findViewById(R.id.FoodFeature);
        tv_FoodFeature.setText(restaurant.getFoodFeature());
    }
}
