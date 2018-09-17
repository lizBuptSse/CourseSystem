<%-- 
    Document   : teacher-add
    Created on : 2018-9-13, 8:23:40
    Author     : Thinker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Course.css">
        <link rel="stylesheet" href="//cdn.bootcss.com/uikit/2.25.0/css/uikit.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <script src="//cdn.bootcss.com/uikit/2.25.0/js/uikit.js"></script>
        <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script> 
        <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script src="js/jquery.carouFredSel-6.2.0-packed.js" type="text/javascript"></script>
        <title>JSP Page</title>  
        <style>
            a
            {
                color:black;
            }
            a:hover
            {
                text-decoration:none;
            }
            #div1
            {
                position:absolute;
                width:30%;
                height:100%;
            }
            #div2
            {
                position:absolute;
                width:30%;
                height:100%;
                display:none;
            }
            #div3
            {
                position:absolute;
                width:70%;
                height:60%;
                left:30%;
            }
        </style>
    </head>
    <body>
        <div id="div1">
            <div class="intro-bar">
                <img src="img/bupt.jpg" alt="bupt" style="width:50px;">
                <div style="font-size:20px;position:absolute;left:20%;top:3%">欢迎回来，xxx</div>
            </div>
            <form class="uk-form uk-form-stacked">
                <i class="uk-icon-angle-right uk-icon-small" style="position:absolute;top:33%;left:15%;"></i>
                <div class="uk-form-row">
                    <a href="teacher.jsp" class="homepage-over-lay">主页</a>                  
                </div>
                <HR style="position:absolute;top:25%;left:20%;"width="60%" color=#987cb9 SIZE=3>
                <div class="uk-form-row">
                    <a href="teacher-add.jsp" class="add-over-lay">添加课程</a>                   
                </div>
                <div class="uk-form-row">
                    <a href="teacher-drop.jsp" class="delete-over-lay">删除课程</a>
                </div>
                <div class="uk-form-row">
                    <a href="teacher-schedule.jsp" class="schedule-over-lay">课程表</a>
                </div>
                <HR style="position:absolute;top:65%;left:20%" width="60%" color=#987cb9 SIZE=3>
                <div class="uk-form-row">
                    <a href="index.jsp" class="logout-over-lay">注销</a>
                </div>
            </form>
        </div>
        <div id="div3">
            <h1 class="uk-heading-midium uk-margin-large-top">添加课程</h1>
            <HR width="100%" color=#987cb9 SIZE=3>
            <div class="uk-form-row uk-margin-top uk-text-bold" style="margin-bottom:30px;">
                <label class="uk-form-label" for="course-name">课程名称：</label>
                <div>
                    <input type="text" id="course-name">
                </div>
            </div>
            <div class="uk-form-row uk-margin-top" style="margin-bottom:20px;">
                <label class="uk-form-label uk-text-bold">时间：</label>
            </div>
            <div class="uk-form uk-margin-small-top">

                <label class="uk-form-label uk-marigin-small-top" for="course-day">请选择星期：</label>
                <div id="course-day" class="uk-form-row" style="margin-bottom:20px;">
                    <i class="uk-icon-calendar">
                        <select>
                            <option id="Monday">星期一</option>
                            <option id="Tuesday">星期二</option>
                            <option id="Wednesday">星期三</option>
                            <option id="Thursday">星期四</option>
                            <option id="Friday">星期五</option>
                            <option id="Saturday">星期六</option>
                            <option id="Sunday">星期日</option>
                        </select>
                    </i>
                </div>

                <div class="uk-margin-small-top uk-form-row">
                    <label class="uk-form-label" for="course-time-slot">请选择时间段：</label>
                    <div id="course-time-slot" class="uk-form" style="margin-bottom:20px;">
                        <i class="uk-icon-clock-o">
                            <select>
                                <option id="timeslot1">8:00~10:00</option>
                                <option id="timeslot2">10:00~12:00</option>
                                <option id="timeslot3">13:30~15:30</option>
                                <option id="timeslot4">15:30~17:30</option>
                                <option id="timeslot5">18:00~20:00</option>
                            </select>
                        </i>
                    </div>
                </div>

            </div>

            <div class="uk-form-row uk-margin-top" style="margin-bottom:20px;">
                <label class="uk-form-label uk-text-bold" for="class-capacity">课容量：</label>
                <div>
                    <input type="text" id="class-capacity">
                </div>
            </div>
            <button class="uk-button uk-margin-top" type="button">确认</button>
        </div>
    </body>
</html>
