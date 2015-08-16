package kr.neosarchizo.bestandroidlibraries;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class MyFragment extends Fragment {


    private EventBus mEventBus = EventBus.getDefault();
    private TextView mTxtReceivedEvent;

    public MyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventBus.register(this);
    }

    @Override
    public void onDestroy() {
        mEventBus.unregister(this);
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        mTxtReceivedEvent = (TextView)view.findViewById(R.id.txtReceivedEvent);
        return view;
    }

    public void onEvent(MyEvent myEvent) {
        mTxtReceivedEvent.setText("Event is fired!!");
    }


}
