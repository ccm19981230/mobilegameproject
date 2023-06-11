package com.weebly.noctiseastern.androidstudioproject7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        Fragment1.OnFragmentInteractionListener,
        Fragment1.OnDataPass,
        Fragment2.OnFragmentInteractionListener,
        Fragment2.OnDataPass,
        Fragment3.OnFragmentInteractionListener,
        Fragment3.OnDataPass,
        View.OnClickListener
{
    TextView player_info, tv_timer;
    private CountDownTimer BonusCountDownTimer;
    public static TextView moneyText;
    static ImageButton btn1, btn2, btn3, btn4;
    private int WhichFragment=0;
    private Fragment fragment = null;
    private RelativeLayout rl_fragment;
    private LinearLayout startPage;
    Boolean noButton = false;
    public static int money = 0;
    static String name = "Player";
    ImageButton exit;
    public static ImageButton player_icon;
    public static TextView player_name;
    public static int player_icon_id = 1;
    static int next;

    static boolean timer_start = false;

    static DBHelper mydb;
    int id_To_Update = 0;

    AllConstants ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyText = findViewById(R.id.moneyText);
        player_name = findViewById(R.id.player_name);

        init_AdView();
        mydb = new DBHelper(this);
        int Value = 1;
        if (mydb.numberOfRows() != 1) {
            mydb.onUpgrade(mydb.getReadableDatabase(),0,1);
            mydb.insertPlayer("Player", 1, 100);
        }
        id_To_Update = Value;
        Cursor cursor = mydb.getData(1);
        cursor.moveToFirst();
        name = cursor.getString(cursor.getColumnIndex(DBHelper.PLAYER_COLUMN_NAME));
        player_name.setText("" + name);
        money = cursor.getInt(cursor.getColumnIndex(DBHelper.PLAYER_COLUMN_MONEY));
        player_icon_id = cursor.getInt(cursor.getColumnIndex(DBHelper.PLAYER_COLUMN_PLAYER_ICON_ID));
        moneyText.setText("" + money);
        cursor.close();

        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);

        player_icon = findViewById(R.id.player_icon);
        player_icon.setOnClickListener(this);

        next = 0;
        initObjects();
        Calendar calender = Calendar.getInstance();
        int currentDay = calender.get(Calendar.DAY_OF_MONTH);
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        int lastDay = settings.getInt("day", 0);

        if(lastDay != currentDay){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("day", currentDay);
            editor.commit();

            money = money + 100;
            moneyText.setText(money);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main6Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                next = 1;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main6Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                next = 2;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main6Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                next = 3;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main8Activity.class);
                startActivity(intent);
                timer_start = true;
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                next = 4;
            }
        });
        player_icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_from_top, R.anim.push_out_to_bottom);
            }
        });
        player_name.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_from_top, R.anim.push_out_to_bottom);
            }
        });

        if(player_icon_id == 1){
            player_icon.setImageResource(R.drawable.player_icon01);
        }else if(player_icon_id == 2){
            player_icon.setImageResource(R.drawable.player_icon02);
        }else if(player_icon_id == 3){
            player_icon.setImageResource(R.drawable.player_icon03);
        }
    }

    public void initObjects() {
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (ImageButton) findViewById(R.id.btn4);
        moneyText = (TextView) findViewById(R.id.moneyText);
        rl_fragment = (RelativeLayout) findViewById(R.id.rl_fragment);
        startPage = (LinearLayout) findViewById(R.id.startPage);
        //player_info = "Coins: " + String.valueOf(ac.default_current_player_coh) + "\n" + "Level: " + String.valueOf(ac.default_current_player_level) + "\n" + "% Progress: "+String.valueOf(ac.default_current_player_level_progress);
    }


    public void onClick(View v) {
        if(v.getId() == R.id.exit){
            finish();
        }
    }

    public void add_coins(){
        money+=200;
    }

    public void start_fragment(Fragment f, int what_animate) {

        Bundle bundle = new Bundle();
        bundle.putString("from_where", "MainActivity");
        f.setArguments(bundle);
        if (f != null) {
            // ========== traditional transaction =================
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (what_animate==1)
                ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            else
                ft.setCustomAnimations(R.anim.pull_in_from_bottom, R.anim.push_out_to_bottom, R.anim.overshoot, R.anim.bounce);
            ft.replace(R.id.rl_fragment, f);//, AllConstants.TAG_FRAGMENT);
            ft.addToBackStack(null);
            //fragmentTransaction.remove(activeFragment).commit();
            ft.commit();
        }

    }

    public void onDataPass(String data) {
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //We can keep this empty
    }

    public void init_AdView() {
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
    }



}

