package kr.neosarchizo.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    TextView txtJSON, txtObject;
    Button btnChange;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJSON = (TextView) findViewById(R.id.txtJSON);
        txtObject = (TextView) findViewById(R.id.txtObject);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new GsonBuilder().create();

                if(txtJSON.getText().toString().length() > 0){
                    person = gson.fromJson(txtJSON.getText().toString(), Person.class);
                    txtJSON.setText(null);
                    txtObject.setText(person.toString());
                } else {
                    txtJSON.setText(gson.toJson(person));
                    txtObject.setText(null);
                }
            }
        });

        txtJSON.setText("{name:\"Junhyuk Lee\",sex:\"man\",age:31}");


    }


}
