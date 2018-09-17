<%-- 
    Document   : login-fail
    Created on : 2018-9-13, 10:00:55
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%

                String   s   =(String)request.getAttribute( "warning");
                out.print(s);
            %>
        </h1>
    </body>
</html>
