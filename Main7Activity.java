package com.weebly.noctiseastern.androidstudioproject7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView star1, star2, star3;
    Button btn_c;
    TextView bonus;
    int star_num;
    int bonus_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        btn_c = findViewById(R.id.btn_c);
        btn_c.setOnClickListener(this);
        bonus = findViewById(R.id.bonus);

        if(MainActivity.next == 1){
            star_num = Main2Activity.star_num;
            bonus_value = Main2Activity.bonus_value;
        }else if(MainActivity.next == 2){
            star_num = Main3Activity.star_num;
            bonus_value = Main3Activity.bonus_value;
        }else if(MainActivity.next == 3){
            star_num = Main4Activity.star_num;
            bonus_value = Main4Activity.bonus_value;
        }
        if(star_num == 1){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.INVISIBLE);
            star3.setVisibility(View.INVISIBLE);
        }else if(star_num == 2){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.INVISIBLE);
        }else if(star_num == 3){
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
        }
        bonus.setText("" + bonus_value);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_c){
            finish();
        }
    }
}
