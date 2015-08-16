package kr.neosarchizo.bestandroidlibraries;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private EventBus mEventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        MyFragment myFragment = new MyFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, myFragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fire_event: {
                mEventBus.post(new MyEvent());
            }
            return true;
        }

        return true;
    }
}
