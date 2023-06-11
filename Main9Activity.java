package com.weebly.noctiseastern.androidstudioproject7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener {

    TextView round1, round2, round3, round4, name1, name2, name3, name4, bonus;
    ImageView icon1, icon2, icon3, icon4;
    Button btn_c;
    String c1, c2, c3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        round1 = findViewById(R.id.round1);
        round2 = findViewById(R.id.round2);
        round3 = findViewById(R.id.round3);
        round4 = findViewById(R.id.round4);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        bonus = findViewById(R.id.bonus);
        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
        icon4 = findViewById(R.id.icon4);
        btn_c = findViewById(R.id.btn_c);
        btn_c.setOnClickListener(this);

        round1.setText(""+ Main8Activity.ai1_round);
        round2.setText(""+Main8Activity.ai2_round);
        round3.setText(""+Main8Activity.ai3_round);
        round4.setText("" + Main8Activity.player_round);

        name1.setText(""+ Main8Activity.country1.getText());
        name2.setText(""+Main8Activity.country2.getText());
        name3.setText(""+Main8Activity.country3.getText());
        name4.setText("" + MainActivity.player_name.getText());

        if(MainActivity.player_icon_id == 1){
            icon4.setImageResource(R.drawable.player_icon01);
        } else if(MainActivity.player_icon_id == 2){
            icon4.setImageResource(R.drawable.player_icon02);
        } else if(MainActivity.player_icon_id == 3){
            icon4.setImageResource(R.drawable.player_icon03);
        }
    if(name1.getText().toString().equals("France")){
            icon1.setImageResource(R.drawable.flag_france);
        }else if(name1.getText().toString().equals("Germany")){
            icon1.setImageResource(R.drawable.flag_germany);
        }else if(name1.getText().toString().equals("Hong Kong")){
            icon1.setImageResource(getResources().getIdentifier("flag_hk", "drawable", getPackageName()));
        }else if(name1.getText().toString().equals("Russia")){
            icon1.setImageResource(getResources().getIdentifier("flag_russia", "drawable", getPackageName()));
        }else if(name1.getText().toString().equals("United Kingdom")){
            icon1.setImageResource(R.drawable.flag_uk);
        }else if(name1.getText().toString().equals("United States")){
            icon1.setImageResource(R.drawable.flag_us);
        }

        if(name2.getText().toString().equals("France")){
            icon2.setImageResource(R.drawable.flag_france);
        }else if(name2.getText().toString().equals("Germany")){
            icon2.setImageResource(R.drawable.flag_germany);
        }else if(name2.getText().toString().equals("Hong Kong")){
            icon2.setImageResource(R.drawable.flag_hk);
        }else if(name2.getText().toString().equals("Russia")){
            icon2.setImageResource(R.drawable.flag_russia);
        }else if(name2.getText().toString().equals("United Kingdom")){
            icon2.setImageResource(R.drawable.flag_uk);
        }else if(name2.getText().toString().equals("United States")){
            icon2.setImageResource(R.drawable.flag_us);
        }

        if(name3.getText().toString().equals("France")){
            icon3.setImageResource(R.drawable.flag_france);
        }else if(name3.getText().toString().equals("Germany")){
            icon3.setImageResource(R.drawable.flag_germany);
        }else if(name3.getText().toString().equals("Hong Kong")){
            icon3.setImageResource(R.drawable.flag_hk);
        }else if(name3.getText().toString().equals("Russia")){
            icon3.setImageResource(R.drawable.flag_russia);
        }else if(name3.getText().toString().equals("United Kingdom")){
            icon3.setImageResource(R.drawable.flag_uk);
        }else if(name3.getText().toString().equals("United States")){
            icon3.setImageResource(R.drawable.flag_us);
        }

        bonus.setText("" + Main8Activity.bonus_value);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_c){
            MainActivity.money += Main8Activity.bonus_value;
            MainActivity.moneyText.setText("" + MainActivity.money);
            MainActivity.mydb.updatePlayer(1, MainActivity.name, MainActivity.player_icon_id, MainActivity.money);
            finish();
        }
    }
}
