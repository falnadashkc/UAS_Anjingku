package kc.si6b.kampuskita.Api;

import kc.si6b.kampuskita.Model.ModelRespon;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ModelRespon> ardRetrieve();

    //penggunaan formulirencoded
    @FormUrlEncoded
    @POST("create.php")
    Call<ModelRespon> ardCreate(
            @Field("Nama") String Nama,
            @Field("Warna") String Warna,
            @Field("Tentang") String Tentang,
            @Field("Asal") String Asal,
            @Field("keunikan") String keunikan

            );

    @FormUrlEncoded
    @POST("update.php")
    Call<ModelRespon> ardUpdate(
            @Field("id") String Id,
            @Field("Nama") String Nama,
            @Field("Warna") String Warna,
            @Field("Tentang") String Tentang,
            @Field("Asal") String Asal,
            @Field("keunikan") String keunikan

            );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ModelRespon> ardDelete(
            @Field("id") String id
    );
}
