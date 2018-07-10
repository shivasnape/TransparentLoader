package com.lab.android.transprentprogressloading.activity;

/*
Created by Shivichu on 10/7/18
*/

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lab.android.transprentprogressloading.R;
import com.lab.android.transprentprogressloading.customloader.CustomProgressLoader;


public class MainActivity extends AppCompatActivity {

    Button mShow;
    CustomProgressLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loader = new CustomProgressLoader(this);

        mShow = (Button) findViewById(R.id.btn_show);


        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loader.setMessage("Sample Transparent Loader......");
                loader.setIsCancelable(false);
                loader.showLoadingDialog();


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        if (loader.isShowing()) {
                            loader.dismissDialog();
                        }

                    }
                }, 3000);

            }
        });

    }
}
