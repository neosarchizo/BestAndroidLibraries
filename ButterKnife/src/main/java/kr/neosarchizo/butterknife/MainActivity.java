package kr.neosarchizo.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.txtTitle)
    TextView txtTitle;

    @Bind({R.id.btnA, R.id.btnB, R.id.btnC})
    List<Button> buttons;

    @OnClick(R.id.btnA)
    void button1() {
        Toast.makeText(this, "Hello!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtTitle.setText("Hello~~~");

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText("Button " + (i + 1));
        }
    }
}
