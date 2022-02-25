package com.example.latihanlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        Button btnMoveActivityData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);
        Button btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveActivityWithObject.setOnClickListener(this);
        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent intent2 = new Intent(MainActivity.this, MoveActivity.class);
                intent2.putExtra("data1","somestring data");
                intent2.putExtra("data2","somestring data2");
                startActivity(intent2);
                break;
            case R.id.btn_move_activity_object:
                Person manusia = new Person("Steffano","Steffano@gmail.com", "Madiun", 17 );
                Intent intent3 = new Intent(MainActivity.this, MoveActivityWithObject.class);
                intent3.putExtra(MoveActivityWithObject.EXTRA_PERSON, manusia);
                startActivity(intent3);
                break;
            case R.id.btn_dial_number:
                String PhoneNumber = "085855028865";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+PhoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}