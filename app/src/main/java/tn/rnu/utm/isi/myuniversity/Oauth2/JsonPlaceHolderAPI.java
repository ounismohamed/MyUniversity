package tn.rnu.utm.isi.myuniversity.Oauth2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderAPI {

    @POST("isi/oauth2/token")
    Call<TokenResponse> getToken(@Body TokenRequest tokenRequest);


/*

    @GET("posts") //This is where we put the path of the rest api
    Call<List<Post>> getPosts();
*/


}
