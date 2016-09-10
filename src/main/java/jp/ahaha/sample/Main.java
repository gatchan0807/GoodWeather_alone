package jp.ahaha.sample;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {
    public static void main(String[] args) throws Exception {

        WebAppContext war = new WebAppContext();
        // ↓ URL を http://hoge.co.jp/sampleapp/sample のような形にしたい場合に使用
        // war.setContextPath("/sampleapp");

        // ↓ src/main/webapp をコンテンツルートファイルに設定したい場合に使用
        // war.setResourceBase("src/main/webapp");

        // war ファイルの場所の取得
        ProtectionDomain domain = Main.class.getProtectionDomain();
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

        Server server = new Server(8080); // 稼働ポートの設定
        server.setHandler(war);
        server.start();
        server.join();
    }
}