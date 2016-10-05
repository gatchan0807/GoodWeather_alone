package jp.ahaha.sample;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.webapp.*;

import java.net.URL;
import java.security.ProtectionDomain;

public class Server {
    public static void main(String[] args) throws Exception {

        WebAppContext war = new WebAppContext();
        // ↓ URL を http://hoge.co.jp/sampleapp/sample のような形にしたい場合に使用
        // war.setContextPath("/sampleapp");

        // ↓ src/main/webapp をコンテンツルートファイルに設定したい場合に使用
        // war.setResourceBase("src/main/webapp");

        // war ファイルの場所の取得
        ProtectionDomain domain = Server.class.getProtectionDomain();
        URL warLocation = domain.getCodeSource().getLocation();
        war.setWar(warLocation.toExternalForm());

        Configuration[] configurations = {
                new AnnotationConfiguration(),
                new WebInfConfiguration(),
                new WebXmlConfiguration(),
                new MetaInfConfiguration(),
                new FragmentConfiguration(),
                new EnvConfiguration(),
                new PlusConfiguration(),
                new JettyWebXmlConfiguration()
        };
        war.setConfigurations(configurations);

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080); // 稼働ポートの設定
        server.setHandler(war);
        server.start();
        server.join();
    }
}