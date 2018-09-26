package cn.john.xa0926a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class ServiceTestActivity extends AppCompatActivity {
    private MyBinder binder;
    private SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        sb=findViewById(R.id.sb);

    }

    public void startSerice(View view) {
        Intent intent=new Intent();
        //intent.putExtra("")
        intent.setClass(this,MyService.class);
        startService(intent);
        //stopService(intent);
    }

    public void bindSerice(View view) {
        Intent intent=new Intent();
        //intent.putExtra("")
        intent.setClass(this,MyService.class);

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder=(MyBinder) service;
                new Thread(){
                    @Override
                    public void run() {
                        while (true){
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            sb.setProgress(binder.getProgress());
                        }
                    }
                }.start();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    public void getProgress(View view) {

        Log.i("john",binder.getProgress()+"......");
    }
}
