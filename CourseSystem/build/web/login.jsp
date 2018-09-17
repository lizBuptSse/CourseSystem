<%-- 
    Document   : login
    Created on : 2018-9-12, 9:18:54
    Author     : liyueyang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="javax.swing.text.Document"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Course.css">
        <link rel="stylesheet" href="//cdn.bootcss.com/uikit/2.25.0/css/uikit.css" />
        <script src="//cdn.bootcss.com/uikit/2.25.0/js/uikit.js"></script>
        <title>JSP Page</title>
        <script>

            function teacher() {
                targetForm = document.forms[0];
                targetForm.action = "login_success";
            }
            function student() {
                targetForm = document.forms[0];
                targetForm.action = "login_success";
            }
        </script>

    </head>
    <body>
        <form class="uk-form" id="loginform" method="get" action="login_success">
            <div class="login">
                <div class="uk-form-row">
                    <div class="uk-form-icon">
                        <i class="uk-icon-user"></i>
                        <input type="text" placeholder="user" name="No" class="uk-form-large uk-form-width-1-1">
                    </div>                                      
                </div>
                <div class="uk-form-row">
                    <div class="uk-form-icon">
                        <i class="uk-icon-lock"></i>
                        <input type="password" placeholder="password" name="Password" class="uk-form-large uk-form-width-1-1">
                    </div>  
                </div>
                <div class="uk-form-row">     
                    <div class="uk-form-controls">
                        <label><input type="radio" name="identity" value="teacher" onclick="teacher()"> 教师</label>
                        <label><input type="radio" name="identity" value="student" onclick="student()"> 学生</label>
                    </div>
                </div>
                <div class="uk-form-row">
                    <button class="uk-button uk-button-large" type="button" style="margin-right:20px" onclick="location.href = 'register.jsp'">注册</button>
                    <button class="uk-button uk-button-primary uk-button-large" type="submit">登陆</button>
                </div>
            </div> 
        </form>      
    </body>
</html>
