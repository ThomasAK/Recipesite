package banana;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public class AppProperties {
    private String passwordSalt ="asldkfjkzjcxvmzncvzncxvmkj";
    private String jwtKey = "dfjasldkfjaa";

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public String getJwtKey() {
        return jwtKey;
    }
}
