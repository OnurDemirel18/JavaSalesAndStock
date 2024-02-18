package tr.com.onurdemirel.core;

public class CoreFields {
    private String userName = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/satisvestok?useUnicode=true&characterEncoding=utf8";

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
