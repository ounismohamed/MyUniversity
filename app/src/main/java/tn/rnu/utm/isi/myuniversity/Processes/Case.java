package tn.rnu.utm.isi.myuniversity.Processes;

public class Case {

    private String tas_uid;
    private String pro_title;
    private String pro_uid;


    public Case(String tas_uid, String pro_title, String pro_uid) {
        this.tas_uid = tas_uid;
        this.pro_title = pro_title;
        this.pro_uid = pro_uid;
    }

    public String getTas_uid() {
        return tas_uid;
    }

    public String getPro_title() {
        return pro_title;
    }

    public String getPro_uid() {
        return pro_uid;
    }
}

