package tn.rnu.utm.isi.myuniversity.Oauth2;

public class TokenRequest {


    private String grant_type;

    private String scope;

    private String client_id;

    private String client_secret ;

    private String username;

    private String password;


    public TokenRequest(String grant_type, String scope, String client_id, String client_secret, String username, String password) {
        this.grant_type = grant_type;
        this.scope = scope;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.username = username;
        this.password = password;
    }
}
