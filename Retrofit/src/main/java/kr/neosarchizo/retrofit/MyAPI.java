package kr.neosarchizo.retrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by JunhyukLee on 15. 9. 15..
 */
public interface MyAPI {
    @GET(Api.USER)
    void getUser(Callback<User> cb);

    @GET(Api.USER)
    User getUser();

    @GET(Api.USERS)
    void getUsers(Callback<List<User>> cb);

    @GET(Api.USERS)
    List<User> getUsers();
}