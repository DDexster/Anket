package Anket;

import Anket.entity.AnketContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class StatisticsServlet extends HttpServlet {

    AnketContainer container = AnketContainer.getContainer();
    Map<String, Integer> osMap = container.getOs().getOsMap();
    Map<String, Integer> ideMap = container.getIde().getIdeMap();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String os = req.getParameter("os");
        String ide = req.getParameter("ide");

        Integer osCount = osMap.get(os);
        Integer ideCount = ideMap.get(ide);
        osMap.put(os, ++osCount);
        ideMap.put(ide, ++ideCount);

        container.getOs().setOsMap(osMap);
        container.getIde().setIdeMap(ideMap);

        AnketContainer.writeContainer(container);

        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("/statistics.jsp");

    }
}
