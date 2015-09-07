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

    //이벤트 수신 등록
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventBus.register(this);
    }

    //이벤트 수신 해제
    @Override
    public void onDestroy() {
        mEventBus.unregister(this);
        super.onDestroy();
    }

    //수신 이벤트 타입 선언
    public void onEvent(MyEvent myEvent) {
        mTxtReceivedEvent.setText("Event is fired!!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        mTxtReceivedEvent = (TextView) view.findViewById(R.id.txtReceivedEvent);
        return view;
    }


}
