package jp.ahaha.goodWeather;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class ApplicationSetting extends ResourceConfig {
    // api パッケージ以下にすべてのAPIのリソースを置くため、そこにアクセスするように指定している
    private static final String API_PACKAGE_PREFIX = ".api";

    public ApplicationSetting() {
            packages(this.getClass().getPackage().getName() + API_PACKAGE_PREFIX);
        }
}