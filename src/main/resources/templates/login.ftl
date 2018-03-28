<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title>登陆页</title>
        <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
        
        
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
        <link rel="stylesheet" href="css/style1.css" type="text/css" media="screen" />
        
        <!-- 
        <link rel="stylesheet" href="css/style2.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style3.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style4.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style5.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style6.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/style7.css" type="text/css" media="screen" />
         -->
        
        
        <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
        
        <!--Internet Explorer Trancparency fix-->
        <!--[if IE 6]>
        <script src="js/ie6pngfix.js"></script>
        <script>
          DD_belatedPNG.fix('#head, a, a span, img, .message p, .click_to_close, .ie6fix');
        </script>
        <![endif]--> 
        
        <script type='text/javascript' src='js/all-ck.js'></script>
        <script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
        <script type='text/javascript' src='js/custom.js'></script>
    </head>
    
    <body class="nobackground">
    	
        <div id="login">
        
        	<h1 class="logo">
            	<a href="">flexy - adjustable admin skin</a>
            </h1>
            <h2 class="loginheading">登录</h2>
            <div class="icon_login ie6fix"></div>

        	<form id="login-form" action="/login/check" method="post">
            <p>
            	<label for="number">账号</label>
            	<input class="input-medium" type="text" value="" name="number" id="number"/>
        	</p>
        	<p>
            	<label for="password">密码</label>
            	<input class="input-medium" type="password" value="" name="password" id="password"/>
        	</p>

            <label>登录方式：</label>
            学生：<input type="radio" name="userType" value="3"/>
            老师：<input type="radio" name="userType" value="2"/>
            管理员：<input type="radio" name="userType" value="1"/>

        	<p class="clearboth">
                <a href="#" onclick="loginCheck()" class="button">登录</a>
        	</p>
            </div>
            </form>
        </div>
        
        <#--<div class="login_message message error">
          <p>用户名或密码错误.</p>
        </div>-->
    </body>
    <script type="text/javascript">
        /**服务器校验**/
        function loginCheck(){

            var number = $("#number").val();
            var password = $("#password").val();
            var userType = $("input[name='userType']:checked").val();
            $.ajax({
                type: "POST",//请求方式为POST
                url: '/login/check',//检验url
                data: {
                    number:number,
                    password:password,
                    userType:userType
                },//请求数据
                dataType:'json',//数据类型为JSON类型
                success: function(res){
                    if(res.code == 0){
                        /*$("#login").tips({
                            side : 1,
                            msg : '正在登录 , 请稍后 ...',
                            bg : '#68B500',
                            time : 10
                        });*/
                        location.href = '/user/index';
                    }else{
                        $("#number").tips({
                            side : 1,
                            msg : "用户名或密码有误",
                            bg : '#FF5080',
                            time : 15
                        });
                        alert(res.desc);
                    }
                }
            });
        }
    </script>
</html>