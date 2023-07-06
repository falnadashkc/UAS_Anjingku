package kc.si6b.kampuskita.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kc.si6b.kampuskita.Api.APIRequestData;
import kc.si6b.kampuskita.Api.RetroServer;
import kc.si6b.kampuskita.Model.ModelRespon;
import kc.si6b.kampuskita.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etnama, etwarna, ettentang, etasal, etkeunikan;
    private Button btntambah;
    private String Nama, warna, tentang, asal, keunikan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etnama = findViewById(R.id.et_nama);
        etwarna = findViewById(R.id.et_warna);
        ettentang = findViewById(R.id.et_tentang);
        etasal = findViewById(R.id.et_asal);
        etkeunikan = findViewById(R.id.et_keunikan);
        btntambah = findViewById(R.id.btn_tambah);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nama = etnama.getText().toString();
                warna = etwarna.getText().toString();
                tentang = ettentang.getText().toString();
                asal = etasal.getText().toString();
                keunikan = etkeunikan.getText().toString();


                if(Nama.trim().isEmpty()){
                   etnama.setError("nama tidak boleh kosong");
                } else if (warna.trim().isEmpty()) {
                    etwarna.setError("warna tidak boleh kosong");
                } else if (tentang.trim().isEmpty()) {
                    ettentang.setError("tentang tidak boleh kosong");
                } else if (asal.trim().isEmpty()) {
                    etasal.setError("asal-muasal tidak boleh kosong");
                } else if (keunikan.trim().isEmpty()) {
                    etkeunikan.setError("keunikan tidak boleh kosong");
                }
                else {
                    tambahkampus();
                }
            }
        });
    }

    private void tambahkampus(){
        APIRequestData API = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelRespon> proses = API.ardCreate(Nama, warna, tentang, asal, keunikan);

        proses.enqueue(new Callback<ModelRespon>() {
            @Override
            public void onResponse(Call<ModelRespon> call, Response<ModelRespon> response) {
                String kode, pesan;
                kode = response.body().getKode();
                pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "kode :" + kode + "pesan : ", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ModelRespon> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal menghubungi server!", Toast.LENGTH_SHORT).show();
                Log.d("Disini", "Error:" + t.getMessage());
            }
        });
    }
}