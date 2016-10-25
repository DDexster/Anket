<%--
  Created by IntelliJ IDEA.
  User: ddexster
  Date: 24.10.16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Anket.entity.AnketContainer" %>
<%@ page import="java.util.Map" %>
<% AnketContainer container = AnketContainer.getContainer();%>
<% Map<String, Integer> osMap = container.getOs().getOsMap();%>
<% Map<String, Integer> ideMap = container.getIde().getIdeMap();%>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<h3 align="center"><b>Statistics</b></h3>
<table align="center" width="700px" height="100px">
    <tr>
        <td width="400px"></td>
        <td align="center"><img
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Windows_logo_%E2%80%93_2012_(dark_blue).svg/50px-Windows_logo_%E2%80%93_2012_(dark_blue).svg.png"/>
        </td>
        <td align="center"><img src="https://pp.vk.me/c629510/v629510801/2af1d/A5FXZ7ybA8w.jpg"></td>
        <td align="center"><img src="http://programy.com.ua/categoriesimages/linux_distributions/linux_icon.png"></td>
    </tr>
    <tr height="30px">
        <td><b>OS popularity statistics:</b></td>
        <td align="center"><h3><%= osMap.get("windows")%>
        </h3></td>
        <td align="center"><h3><%= osMap.get("iOs")%>
        </h3></td>
        <td align="center"><h3><%= osMap.get("linux")%>
        </h3></td>
    </tr>
</table>
<p>


</p>
<table align="center" width="700px" height="100px">
    <tr>
        <td></td>
        <td align="center"><img src="http://www.obnovisoft.ru/images/icons/intellij-idea.png"></td>
        <td align="center"><img src="http://www.eclipse.org/downloads/images/committers.png"></td>
        <td align="center"><img
                src="https://cdn0.iconfinder.com/data/icons/48px_icons_collection_by_neweravin/48/netbeans.png"></td>
    </tr>
    <tr height="30px">
        <td width="400px"><b>Java IDE popularity statistics:</b></td>
        <td align="center"><h3><%= ideMap.get("idea")%>
        </h3></td>
        <td align="center"><h3><%= ideMap.get("eclipse")%>
        </h3></td>
        <td align="center"><h3><%= ideMap.get("netbeans")%>
        </h3></td>
    </tr>
</table>
</body>
</html>
