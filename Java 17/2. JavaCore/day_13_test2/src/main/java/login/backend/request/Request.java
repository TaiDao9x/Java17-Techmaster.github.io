package login.backend.request;

public class Request {

    private String userName;
    private String email;
    private String Password;

    public Request(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        Password = password;
    }

    public Request(String email, String password) {
        this.email = email;
        Password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
