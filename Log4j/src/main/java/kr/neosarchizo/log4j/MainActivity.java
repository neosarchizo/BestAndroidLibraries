package kr.neosarchizo.log4j;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.apache.log4j.Logger;

public class MainActivity extends AppCompatActivity {

    private Logger mLogger = Logger.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogger.info("onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLogger.info("onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mLogger.info("onPause");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLogger.info("onDestroy");
    }
}