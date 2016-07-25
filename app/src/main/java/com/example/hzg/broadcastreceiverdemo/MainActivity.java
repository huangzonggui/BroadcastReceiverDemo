package com.example.hzg.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.R.attr.filter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册的receiver先收到
//        IntentFilter filter = new IntentFilter("BC_One");
//        BC1 bc1 = new BC1();
//        registerReceiver(bc1, filter);
    }
    public void doClick(View view) {
        switch (view.getId()) {
            //普通广播,通过ＢＣ１与ＢＣ２做对比
            case R.id.sendNormal:
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条普通的广播");
                intent.setAction("BC_One");
                sendBroadcast(intent);
                break;

            case R.id.sendOrder:
                Intent intent2 = new Intent();
                intent2.putExtra("msg", "这是一条有序广播");
                intent2.setAction("BC_One");
                sendOrderedBroadcast(intent2,null);
                break;
            case R.id.sendAsyn:
                Intent intent3 = new Intent();
                intent3.putExtra("msg", "这是一条异步广播");
                intent3.setAction("BC_Three");
                sendStickyBroadcast(intent3);
                //先发送，后注册
                IntentFilter intentfileter = new IntentFilter("BC_Three");
                BC3 bc3 = new BC3();
                registerReceiver(bc3, intentfileter);
                break;
        }
    }
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
//		unregisterReceiver(receiver);
    }
}
