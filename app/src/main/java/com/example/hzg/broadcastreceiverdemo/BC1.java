package com.example.hzg.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hzg on 16-7-25.
 */
public class BC1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        Log.i("main", "receiver1收到的信息：" + s);
        abortBroadcast();
//        Bundle bundle = new Bundle();
//        bundle.putString("test","广播处理的数据");
//        setResultExtras(bundle);

    }
}
