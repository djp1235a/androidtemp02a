package cn.john.xa0926a;


import android.os.Binder;

/**
 * Created by john on 2018/9/26.
 */

public class MyBinder extends Binder {
    private  int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
