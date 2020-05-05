package server;

import server.mapper.Context;
import server.mapper.Mapper;
import server.mapper.Wrapper;

import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class RequestProcessor extends Thread {

    private Socket socket;
    private Mapper mapper;

    public RequestProcessor(Socket socket, Mapper mapper) {
        this.socket = socket;
        this.mapper = mapper;
    }

    @Override
    public void run() {
        //根据url过滤查找servlet
        try {
            InputStream inputStream = null;
            HttpServlet servlet = null;
            inputStream = socket.getInputStream();
            //封装request和response
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());
            //拆分/demo1/lagou
            String requestUrl = request.getUrl();
            String[] split = requestUrl.split("/");
            if (split.length > 2) {
                String contextName = split[1];
                String servletName = split[2];
                List<Context> contextList = mapper.getHost().getContextList();
                for (Context context : contextList) {
                    if (context.getAppName().equals(contextName)) {
                        List<Wrapper> wrapperList = context.getWrapperList();
                        for (Wrapper wrapper : wrapperList) {
                            if (wrapper.getServletMap().containsKey(servletName)) {
                                servlet = wrapper.getServletMap().get(servletName);
                                break;
                            }
                        }
                        if (servlet != null) break;
                    }
                }
            }
            if (servlet == null) {
                //处理静态资源
                response.outputHtml(requestUrl);
            } else {
                //处理动态资源
                servlet.service(request, response);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
