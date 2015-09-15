package kr.neosarchizo.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtResponse;
    Button btnGetUser, btnGetUserAsync, btnGetUsers, btnGetUsersAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResponse = (TextView) findViewById(R.id.txtResponse);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Api.HOST).build();
        final MyAPI myAPI = restAdapter.create(MyAPI.class);

        btnGetUser = (Button) findViewById(R.id.btnGetUser);
        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final User user = myAPI.getUser();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtResponse.setText("name : " + user.name + "\npassword : " + user.password);
                            }
                        });
                    }
                });
                thread.start();
            }
        });

        btnGetUserAsync = (Button) findViewById(R.id.btnGetUserAsync);
        btnGetUserAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAPI.getUser(new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        txtResponse.setText("name : " + user.name + "\npassword : " + user.password);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        btnGetUsers = (Button) findViewById(R.id.btnGetUsers);
        btnGetUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final List<User> users = myAPI.getUsers();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtResponse.setText(null);
                                for (User user : users) {
                                    txtResponse.append("name : " + user.name + "\npassword : " + user.password + "\n");
                                }
                            }
                        });
                    }
                });
                thread.start();
            }
        });

        btnGetUsersAsync = (Button) findViewById(R.id.btnGetUsersAsync);
        btnGetUsersAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAPI.getUsers(new Callback<List<User>>() {
                    @Override
                    public void success(List<User> users, Response response) {
                        txtResponse.setText(null);
                        for (User user : users) {
                            txtResponse.append("name : " + user.name + "\npassword : " + user.password + "\n");
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });
    }
}
