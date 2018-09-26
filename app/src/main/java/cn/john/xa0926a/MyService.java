package cn.john.xa0926a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private boolean stop=false;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("john","myservice create.....");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("john","myservice desc.....");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //intent.getStringExtra("")
        Log.i("john","myservice command.....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
       final MyBinder binder=new MyBinder();
       new Thread(){
           @Override
           public void run() {
                while (!stop){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int p=binder.getProgress();
                    binder.setProgress(++p);

                }
           }
       }.start();
       return binder;
    }

}
