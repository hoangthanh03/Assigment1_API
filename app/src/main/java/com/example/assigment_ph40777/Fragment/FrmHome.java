package com.example.assigment_ph40777.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assigment_ph40777.Adapter.MotorAdapter;
import com.example.assigment_ph40777.Model.API_Server;
import com.example.assigment_ph40777.Model.MotorModel;
import com.example.assigment_ph40777.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FrmHome extends AppCompatActivity {

    ListView lvXe;
    List<MotorModel> danhSachXe; // Thay đổi tên biến để tránh nhầm lẫn
    MotorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_home);

        lvXe = findViewById(R.id.lvXe);
        danhSachXe = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Server.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Server api = retrofit.create(API_Server.class);

        Call<List<MotorModel>> call = api.getMotors();

        call.enqueue(new Callback<List<MotorModel>>() {
            @Override
            public void onResponse(Call<List<MotorModel>> call, Response<List<MotorModel>> response) {
                if (response.isSuccessful()) {
                    List<MotorModel> fetchedMotors = response.body();
                    if (fetchedMotors != null && !fetchedMotors.isEmpty()) {
                        danhSachXe.clear(); // Xóa dữ liệu cũ
                        danhSachXe.addAll(fetchedMotors); // Thêm dữ liệu mới
                        adapter.notifyDataSetChanged(); // Cập nhật RecyclerView
                    } else {
                        Log.e("Home", "Empty or null response");
                    }
                } else {
                    Log.e("Home", "Failed to get motors: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<MotorModel>> call, Throwable t) {
                Log.e("Main", t.getMessage());
                Toast.makeText(FrmHome.this, "Lỗi khi tải dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });

        // Khởi tạo adapter sau khi gán dữ liệu từ API
        adapter = new MotorAdapter(danhSachXe, FrmHome.this);
        lvXe.setAdapter(adapter);
    }
}
