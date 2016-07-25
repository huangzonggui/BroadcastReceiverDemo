package com.example.hzg.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hzg on 16-7-25.
 */
public class BC2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        Log.i("main", "receiver2收到的信息：" + s);
//        abortBroadcast();
        Bundle bundle = getResultExtras(true);
        String s2 = bundle.getString("test");
        Log.i("main", "得到的处理结果是：" + s2);
    }
}
