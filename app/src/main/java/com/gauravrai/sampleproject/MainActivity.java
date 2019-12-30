package com.gauravrai.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.gauravrai.sampleproject.API.Model.APIClient;
import com.gauravrai.sampleproject.API.Model.APIInterface;
import com.gauravrai.sampleproject.API.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private APIInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        api = APIClient.getClient().create(APIInterface.class);

        api.fetchToDoList().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()) {
                    List<User> users = response.body();
                    UserAdapter adapter = new UserAdapter(MainActivity.this, users);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Check for working internet", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
