package jp.ahaha.goodWeather.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sample") // アクセスするURL
public class SampleController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        // メイン処理部
        response.getWriter().println("<h1>Hello Jetty World!</h1>");
        response.getWriter().println("CopyRight @ahaha0807_alg(Twitter, Qiita, GitHub : @ahaha0807)");
    }
}