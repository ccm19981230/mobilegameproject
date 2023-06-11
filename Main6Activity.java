package com.weebly.noctiseastern.androidstudioproject7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    private RadioGroup rg1, rg2;
    private Button start_btn;
    private ImageButton exit;
    static int card_option = 1;
    static int preview_option = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rg1 = findViewById(R.id.rg1);

        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);
        rg2 = findViewById(R.id.rg2);

        start_btn = findViewById(R.id.start_btn);
        exit = findViewById(R.id.exit);
        start_btn.setOnClickListener(this);
        //start_btn.setClickable(false);
        ((RadioGroup) findViewById(R.id.rg1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rb1.getId()){
                    preview_option = 1;
                }else if(checkedId == rb2.getId()){
                    preview_option = 2;
                }else if(checkedId == rb3.getId()){
                    preview_option = 3;
                }
                //start_btn.setClickable(true);
            }
        });
        ((RadioGroup) findViewById(R.id.rg2)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rb4.getId()){
                    card_option = 1;
                }else if(checkedId == rb5.getId()){
                    card_option = 2;
                }else if(checkedId == rb6.getId()){
                    card_option = 3;
                }
            }
        });

        if(preview_option == 1){
            rb1.setChecked(true);
            rb2.setChecked(false);
            rb3.setChecked(false);
        }else if(preview_option == 2){
            rb1.setChecked(false);
            rb2.setChecked(true);
            rb3.setChecked(false);
        }else if(preview_option == 3){
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(true);
        }

        if(card_option == 1){
            rb4.setChecked(true);
            rb5.setChecked(false);
            rb6.setChecked(false);
        }else if(card_option == 2){
            rb4.setChecked(false);
            rb5.setChecked(true);
            rb6.setChecked(false);
        }else if(card_option == 3){
            rb4.setChecked(false);
            rb5.setChecked(false);
            rb6.setChecked(true);
        }
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.exit){
            finish();
        }
        if(v.getId() == R.id.start_btn){
            Intent intent = new Intent(Main6Activity.this, Main6Activity.class);
            if(MainActivity.next == 1){
                intent = new Intent(Main6Activity.this, Main2Activity.class);
            }else if(MainActivity.next == 2){
                intent = new Intent(Main6Activity.this, Main3Activity.class);
            }else if(MainActivity.next == 3){
                intent = new Intent(Main6Activity.this, Main4Activity.class);
            }else if(MainActivity.next == 4){
                intent = new Intent(Main6Activity.this, Main8Activity.class);
            }
            startActivity(intent);
            overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
            finish();
        }
    }
}
