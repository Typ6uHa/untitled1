package itis.model;

public class AccountStruct {

    private String login;
    private String password;

    public AccountStruct(String name, String password ) {
        this.login = name;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
