<%-- 
    Document   : register
    Created on : 2018-9-12, 9:18:43
    Author     : liyueyang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" pageEncoding="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Course.css">
        <link rel="stylesheet" href="//cdn.bootcss.com/uikit/2.25.0/css/uikit.css" />
        <script src="//cdn.bootcss.com/uikit/2.25.0/js/uikit.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="register uk-panel uk-panel-header">
            <h3 class="uk-panel-title" style="font-size:30px;">注册用户</h3>
            <form class="uk-form uk-form-stacked" enctype="application/x-www-form-urlencoded"  action="register_success">
                <div class="uk-form-row" style="margin-top:20px">
                    <label class="uk-form-label" for="form-s-user">学号：</label>
                    <div>
                        <input type="text" id="form-s-user" name="No">
                    </div>
                </div>
                <div class="uk-form-row">
                    <label class="uk-form-label" for="form-s-name">姓名：</label>
                    <div>
                        <input type="text" id="form-s-name" name="Name">
                    </div>
                </div>
                <div class="uk-form-row">
                    <label class="uk-form-label" for="form-s-password">密码：</label>
                    <div>
                        <input type="password" id="form-s-password" name="Password">
                    </div>
                </div>
                <div class="uk-form-row" style="margin-bottom:40px;">
                    <label class="uk-form-label" for="form-s-confirm">确认密码：</label>
                    <div>
                        <input type="password" id="form-s-confirm" name="Confirm">
                    </div>
                </div>
                <input type="submit" name="submit" value="提交">
                   
            </form>

            
        </div>

    </body>
</html>
