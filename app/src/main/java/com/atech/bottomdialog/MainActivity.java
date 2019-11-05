package com.atech.bottomdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.desongdialog.CustomDialog;
import com.desongdialog.DialogListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btn,btn2,btn3;
    CustomDialog basedialog,titledialog,customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        initDialogs();

    }

    private void initDialogs(){

        String[]datas = new String[]{"aaa", "bbb", "cccc"};

         basedialog = new CustomDialog(this);
         basedialog.init(datas, new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });

        //带标题，同时自定义风格（这样可以保证宽度占满屏幕）
        titledialog = new CustomDialog(this,R.style.customdialog);
        titledialog.init(datas, "请选择", new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });

        customDialog = new CustomDialog(this);
        customDialog.init(datas, R.layout.item_header, new DialogListener() {
            @Override
            public void onItemClick(int pos) {

                //your logic

            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn:

                basedialog.show();


                break;

            case R.id.btn2:

                titledialog.show();

                break;

            case R.id.btn3:


                customDialog.show();

                break;

        }

    }
}
