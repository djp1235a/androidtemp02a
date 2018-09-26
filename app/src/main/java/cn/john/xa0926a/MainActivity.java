package cn.john.xa0926a;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private TextView colorPan;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorPan=findViewById(R.id.colorPan);
        
        redBar=findViewById(R.id.redBar);
        greenBar=findViewById(R.id.greenBar);
        blueBar=findViewById(R.id.blueBar);

        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red=redBar.getProgress();
        int green=greenBar.getProgress();
        int blue=blueBar.getProgress();
        int c= Color.rgb(red,green,blue);
        colorPan.setBackgroundColor(c);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
