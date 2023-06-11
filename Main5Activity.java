package com.weebly.noctiseastern.androidstudioproject7;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.weebly.noctiseastern.androidstudioproject7.MainActivity.player_icon_id;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener   {
    ImageButton exit;
    ImageView player_icon;
    ImageButton player_icon01;
    ImageButton player_icon02;
    ImageButton player_icon03;
    EditText editText;
    Button btn_enter;
    TextView player_name;
    String player_name_value;
    int player_icon_id = MainActivity.player_icon_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
        player_icon = findViewById(R.id.player_icon);
        player_icon01 = findViewById(R.id.player_icon01);
        player_icon01.setOnClickListener(this);
        player_icon02 = findViewById(R.id.player_icon02);
        player_icon02.setOnClickListener(this);
        player_icon03 = findViewById(R.id.player_icon03);
        player_icon03.setOnClickListener(this);
        editText = findViewById(R.id.editText);
        btn_enter = findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(this);
        player_name = findViewById(R.id.player_name);
        player_name_value = MainActivity.player_name.getText().toString();
        player_name.setText("" + player_name_value);
        editText.setText("" + player_name_value);
        if(player_icon_id == 1){
            player_icon.setImageResource(R.drawable.player_icon01);
            player_icon01.setBackgroundColor(Color.GRAY);
            player_icon02.setBackgroundColor(Color.TRANSPARENT);
            player_icon03.setBackgroundColor(Color.TRANSPARENT);
        } else if(player_icon_id == 2){
            player_icon.setImageResource(R.drawable.player_icon02);
            player_icon02.setBackgroundColor(Color.GRAY);
            player_icon01.setBackgroundColor(Color.TRANSPARENT);
            player_icon03.setBackgroundColor(Color.TRANSPARENT);
        } else if(player_icon_id == 3){
            player_icon.setImageResource(R.drawable.player_icon03);
            player_icon03.setBackgroundColor(Color.GRAY);
            player_icon01.setBackgroundColor(Color.TRANSPARENT);
            player_icon02.setBackgroundColor(Color.TRANSPARENT);
        }

    }
    public void onClick(View v) {
        if(v.getId() == R.id.exit){
            finish();
        }
        if(v.getId() == R.id.player_icon01){
            player_icon.setImageResource(R.drawable.player_icon01);
            MainActivity.player_icon.setImageResource(R.drawable.player_icon01);
            player_icon01.setBackgroundColor(Color.GRAY);
            player_icon02.setBackgroundColor(Color.TRANSPARENT);
            player_icon03.setBackgroundColor(Color.TRANSPARENT);
            player_icon_id = 1;
            MainActivity.mydb.updatePlayer(1, player_name.getText().toString(), player_icon_id, MainActivity.money);
        }
        if(v.getId() == R.id.player_icon02){
            player_icon.setImageResource(R.drawable.player_icon02);
            MainActivity.player_icon.setImageResource(R.drawable.player_icon02);
            player_icon02.setBackgroundColor(Color.GRAY);
            player_icon01.setBackgroundColor(Color.TRANSPARENT);
            player_icon03.setBackgroundColor(Color.TRANSPARENT);
            player_icon_id = 2;
            MainActivity.mydb.updatePlayer(1, player_name.getText().toString(), player_icon_id, MainActivity.money);
        }
        if(v.getId() == R.id.player_icon03){
            player_icon.setImageResource(R.drawable.player_icon03);
            MainActivity.player_icon.setImageResource(R.drawable.player_icon03);
            player_icon03.setBackgroundColor(Color.GRAY);
            player_icon01.setBackgroundColor(Color.TRANSPARENT);
            player_icon02.setBackgroundColor(Color.TRANSPARENT);
            player_icon_id = 3;
            MainActivity.mydb.updatePlayer(1, player_name.getText().toString(), player_icon_id, MainActivity.money);
        }
        if(v.getId() == R.id.btn_enter){
            String str = editText.getText().toString();
            player_name.setText(""+str);
            MainActivity.mydb.updatePlayer(1, str, player_icon_id, MainActivity.money);
            MainActivity.player_name.setText(""+str);
        }
    }
}
