package tn.rnu.utm.isi.myuniversity.Oauth2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tn.rnu.utm.isi.myuniversity.Processes.Case;

public interface JsonPlaceHolderAPI {

    @POST("isi/oauth2/token")
    Call<TokenResponse> getToken(@Body TokenRequest tokenRequest);


/*

    @GET("posts") //This is where we put the path of the rest api
    Call<List<Post>> getPosts();
*/

    @GET("http://process.isiforge.tn/api/1.0/isi/case/start-cases")
    Call<Case> getUser(@Path("id") String id, @Header("Authorization") String authHeader);

}
