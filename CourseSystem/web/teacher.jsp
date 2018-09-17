<%-- 
    Document   : teacher
    Created on : 2018-9-12, 9:19:39
    Author     : liyueyang
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
        <script>
            $(function () {
                $('#slider').carouFredSel({
                    width: '100%',
                    align: false,
                    items: 3,
                    items: {
                        width: $('#wrapper').width() * 0.15,
                        height: 500,
                        visible: 1,
                        minimum: 1
                    },
                    scroll: {
                        items: 1,
                        timeoutDuration: 5000,
                        onBefore: function (data) {

                            //	find current and next slide
                            var currentSlide = $('.slide.active', this),
                                    nextSlide = data.items.visible,
                                    _width = $('#wrapper').width();
                            //	resize currentslide to small version
                            currentSlide.stop().animate({
                                width: _width * 0.15
                            });
                            currentSlide.removeClass('active');
                            //	hide currentblock
                            data.items.old.add(data.items.visible).find('.slide-block').stop().fadeOut();

                            //	animate clicked slide to large size
                            nextSlide.addClass('active');
                            nextSlide.stop().animate({
                                width: _width * 0.7
                            });
                        }, onAfter: function (data) {
                            //	show active slide block
                            data.items.visible.last().find('.slide-block').stop().fadeIn();
                        }
                    },
                    onCreate: function (data) {

                        //	clone images for better sliding and insert them dynamacly in slider
                        var newitems = $('.slide', this).clone(true),
                                _width = $('#wrapper').width();
                        $(this).trigger('insertItem', [newitems, newitems.length, false]);
                        //	show images 
                        $('.slide', this).fadeIn();
                        $('.slide:first-child', this).addClass('active');
                        $('.slide', this).width(_width * 0.15);
                        //	enlarge first slide
                        $('.slide:first-child', this).animate({
                            width: _width * 0.7
                        });

                        //	show first title block and hide the rest         $(this).find( '.slide-block' ).hide();
                        $(this).find('.slide.active .slide-block').stop().fadeIn();
                    }
                });

                //	Handle click events
                $('#slider').children().click(function () {
                    $('#slider').trigger('slideTo', [this]);
                });

                //	Enable code below if you want to support browser resizing
                $(window).resize(function () {

                    var slider = $('#slider'),
                            _width = $('#wrapper').width();
                    //	show images
                    slider.find('.slide').width(_width * 0.15);
                    //	enlarge first slide
                    slider.find('.slide.active').width(_width * 0.7);
                    //	update item width config
                    slider.trigger('configuration', ['items.width', _width * 0.15]);
                });

            });
        </script>
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
                width:70%;
                height:60%;
                left:30%;
            }
            #div3
            {
                position:absolute;
                width:70%;
                height:50%;
                left:30%;
                top:50%;
                background-color:#F8F8FF;
            }
            #wrapper{position:absolute;height:100%;width:100%;}
            /* slider */
            #slider{height:100%;overflow:hidden;background:url(img/ajax-loader.gif) center center no-repeat;}
            #slider .slide{position:relative;display:none;height:80%;float:left;background-position:center right;cursor:pointer;border-left:1px solid #fff;}
            #slider .slide:first-child{border:none;}
            #slider .slide.active{cursor:default;}
            #slider .slide-block{position:absolute;left:40px;bottom:75px;display:inline-block;width:435px;background-color:#fff;background-color:rgba(255,255,255, 0.8);*background-color:#fff;background-color:#fff\9;padding:20px;font-size:14px;color:#134B94;border:1px solid #fff;overflow:hidden;border-radius:4px;}
            #slider .slide-block h4{font-size:36px;font-weight:bold;margin:0 0 10px 0;line-height:1;}
            #slider .slide-block p{margin:0;}
        </style>
    </head>
    <body>
        <div id="div1">
            <div class="intro-bar">
                <img src="img/bupt.jpg" alt="bupt" style="width:50px;">
                <div style="font-size:20px;position:absolute;left:20%;top:3%">欢迎回来，xxx</div>
            </div>
            <form class="uk-form uk-form-stacked">
                <i class="uk-icon-angle-right uk-icon-small" style="position:absolute;top:20%;left:15%;"></i>
                <div class="uk-form-row">
                    <a href="teacher.jsp" class="homepage-over-lay">主页</a>                  
                </div>
                <HR style="position:absolute;top:25%;left:20%;"width="60%" color=#987cb9 SIZE=3>
                <div class="uk-form-row">
                    <a href="teacher_add.jsp" class="add-over-lay">添加课程</a>                   
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
        <div id="div2">              
            <div id="wrapper">

                <div id="slider">

                    <div class="slide" style="background-image: url(img/1.jpg);">
                        <div class="slide-block">
                            <h4>Ice Age</h4>
                            <p>Heading south to avoid a bad case of global 
                                frostbite, a group of migrating misfit creatures embark 
                                on a hilarious quest to reunite a human baby with his 
                                tribe.</p>
                        </div>
                    </div>

                    <div class="slide" style="background-image: url(img/2.jpg);">
                        <div class="slide-block">
                            <h4>For The Birds</h4>
                            <p>For the Birds is an animated short film, produced by 
                                Pixar Animation Studios released in 2000. It is shown in 
                                a theatrical release of the 2001 Pixar feature film 
                                Monsters, Inc.</p>
                        </div>
                    </div>

                    <div class="slide" style="background-image: url(img/3.jpg);">
                        <div class="slide-block">
                            <h4>UP</h4>
                            <p>A comedy adventure in which 78-year-old Carl 
                                Fredricksen fulfills his dream of a great adventure when 
                                he ties thousands of balloons to his house and flies 
                                away to the wilds of South America.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="div3" >
            <img src="img/4.png" style="width:30%;position:absolute;left:2%;top:10%;">
            <img src="img/5.jpg" style="width:30%;position:absolute;left:35%;top:10%">
            <img src="img/6.jpg" style="width:30%;position:absolute;left:68%;top:10%">
            <div class="uk-panel uk-panel-box" style="width:27%;height:20%;position:absolute;left:2%;top:60%">
                <div class="uk-panel-badge uk-badge uk-badge-danger">
                    Hot
                </div>
                111
            </div>
            <div class="uk-panel uk-panel-box" style="width:27%;height:20%;position:absolute;left:35%;top:60%">
                <div class="uk-panel-badge uk-badge uk-badge-danger">
                    Hot
                </div>
                222
            </div>
            <div class="uk-panel uk-panel-box" style="width:27%;height:20%;position:absolute;left:68%;top:60%">
                <div class="uk-panel-badge uk-badge uk-badge-danger">
                    Hot
                </div>
                333
            </div>
        </div>
    </body>
</html>
