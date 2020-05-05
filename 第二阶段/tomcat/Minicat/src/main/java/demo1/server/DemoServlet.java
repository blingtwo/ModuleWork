package demo1.server;

import server.HttpProtocolUtil;
import server.HttpServlet;
import server.Request;
import server.Response;

import java.io.IOException;

public class DemoServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) {
        try {
            System.out.println("执行了 GET 方法");
            String content = "<h1>Demo1Servlet GET</h1>";
            response.output(HttpProtocolUtil.getHttpHeader200(content.length())+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        try {
            System.out.println("执行了 POST 方法");
            String content = "<h1>Demo1Servlet POST</h1>";
            response.output(HttpProtocolUtil.getHttpHeader200(content.length())+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destory() throws Exception {

    }
}
