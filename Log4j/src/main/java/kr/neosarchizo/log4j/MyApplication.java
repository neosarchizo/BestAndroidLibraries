package kr.neosarchizo.log4j;

import android.app.Application;
import android.os.Environment;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by JunhyukLee on 15. 9. 7..
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.setFileName(Environment.getExternalStorageDirectory() + "/neosarchizo/Logs/logFile.log");
        logConfigurator.configure();
    }
}
