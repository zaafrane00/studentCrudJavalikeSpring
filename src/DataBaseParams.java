public class DataBaseParams {
    public String driver;
    public String url;
    public String session;
    public String password;

    public DataBaseParams(String driver, String url, String session, String password) {
        this.driver = driver;
        this.url = url;
        this.session = session;
        this.password = password;
    }

    public DataBaseParams() {

    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getSession() {
        return session;
    }

    public String getPassword() {
        return password;
    }
}
