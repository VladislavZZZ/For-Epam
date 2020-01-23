package by.javatr.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User that = (User) o;
        return (login == null ? that.login == null : login.equals(that.login) &&
                password == null ? that.password == null : password.equals(that.password));
    }

    @Override
    public int hashCode() {
        int result = (login == null ? 0 : login.hashCode());
        result = 31 * result + (password == null ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : { id: " + login + "; password: " + password + "}";
    }

}
