package com.example.epilepsy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    MediaPlayer mediaPlayer;
    String url;
    int[] arr={0,1,0};
    void init(){
        textView1=findViewById(R.id.textView0or1);
        mediaPlayer=new MediaPlayer();
        url="https://firebasestorage.googleapis.com/v0/b/epialert-dd9fa.appspot.com/o/Alarm.mp3?alt=media&token=a09595e3-289f-4d96-a1d7-4434fb642fa2";

    }
    void function(){
        for(int i=0;i<arr.length;i++){
            textView1.setText(arr[i]);
            if(arr[i]==1){
                try{
                    mediaPlayer.setDataSource(this, Uri.parse(url));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                mediaPlayer.stop();
                mediaPlayer.release();
                finish();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        function();
    }
}