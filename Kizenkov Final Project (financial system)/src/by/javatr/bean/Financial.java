package by.javatr.bean;

public class Financial {
    private String login;
    private double gain;
    private double spend;

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Financial that = (Financial) o;
        if (gain != that.gain || spend !=that.spend) {
            return false;
        }
        return login == null ? that.login == null : login.equals(that.login);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + Double.valueOf(gain).hashCode();
        result = 31 * result + Double.valueOf(spend).hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " :\n { id: " + login + ";\n income: " + gain +
                ";\n expenses: " + spend + "}";
    }}
