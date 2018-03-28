<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title>高校教材管理系统</title>
        <link rel="stylesheet" href="/css/style_all.css" type="text/css" media="screen" />
        
        
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
        <link rel="stylesheet" href="/css/style8.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="/css/jquery-ui.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
        
        <!--Internet Explorer Trancparency fix-->
        <!--[if IE 6]>
        <script src="/js/ie6pngfix.js"></script>
        <script>
          DD_belatedPNG.fix('#head, a, a span, img, .message p, .click_to_close, .ie6fix');
        </script>
        <![endif]--> 
        
        <script type='text/javascript' src='/js/all-ck.js'></script>
        <#--<script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>-->
        <#--<script type='text/javascript' src='/js/custom.js'></script>-->
    </head>
    
    <body>
        <div id="top">
            <div id="head">
                <h1 class="logo">
                    <a href=""></a>
                </h1>
                <div class="head_memberinfo">
                    <#--<div class="head_memberinfo_logo">
                        <span>1</span>
                        <img src="images/unreadmail.png" alt=""/>
                    </div>-->
                    
                    <span class='memberinfo_span'>
                       欢迎 <a href="">${info.name}</a>
                   </span>

                   <span class='memberinfo_span'>
                    <a href="">设置</a>
                </span>

                <span>
                    <a href="/login/out">登出</a>
                </span>

                <#--<span class='memberinfo_span2'>
                    <a href="">1 条私信</a>
                </span>-->
            </div>
            <!--end head_memberinfo-->
            
        </div>
            <!--end head-->
           	
            	<div id="bg_wrapper">
                
                    <div id="main">
                        <div id="content">
                            <h2>个人中心</h2>
                            <div>
                                <table>
                                    <tr>
                                        <th class="specalt">姓名: </th>
                                        <td>${info.name}</td>
                                    </tr>
                                    <tr>
                                        <th class="specalt">登录账号: </th>
                                        <td>${info.number}</td>
                                    </tr>
                                    <tr>
                                        <th class="specalt">身份:</th>
                                        <td>
                                            <#if userType == '1'>
                                                管理员
                                            <#elseif userType == '2'>
                                                老师
                                            <#else>
                                                学生
                                            </#if>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <!--end content-->

                    </div><!--end main-->
                    
                    <div id="sidebar">
                        <ul class="nav">
                            <#if userType == '1'>
                                <li><a class="headitem item1" href="/textBook/insert">教材入库管理</a></li>
                                <li><a class="headitem item2" href="/reserve/index?status=0">教材订单管理</a></li>
                                <li><a class="headitem item4" href="/textBook/index">教材信息查询</a></li>
                                <li><a class="headitem item5" href="/reserve/index">历史订单</a></li>
                                <li><a class="headitem item6" href="/user/index">个人中心</a></li>
                            <#elseif userType == '2'>
                                <li><a class="headitem item1" href="/reserve/insert">教材订阅</a></li>
                                <li><a class="headitem item4" href="/textBook/index">教材信息查询</a></li>
                                <li><a class="headitem item5" href="/reserve/index">历史订单</a></li>
                                <li><a class="headitem item6" href="/user/index">个人中心</a></li>
                            <#else>
                                <li><a class="headitem item4" href="/textBook/index">教材信息查询</a></li>
                                <li><a class="headitem item6" href="/user/index">个人中心</a></li>
                            </#if>
                            <#--<li><a class="headitem item1" href="/reserve/insert">教材订阅</a></li>
                            <li><a class="headitem item1" href="/textBook/insert">教材入库管理</a></li>
                            <li><a class="headitem item2" href="/reserve/index?status=0">教材订单管理</a></li>
                            <li><a class="headitem item4" href="/textBook/index">教材信息查询</a></li>
                            <li><a class="headitem item5" href="#">历史订单</a></li>
                            <li><a class="headitem item6" href="#">个人中心</a></li>-->
                        </ul><!--end subnav-->

                </div>
                    <!--end sidebar-->
                        
                     </div><!--end bg_wrapper-->
                     
                <div id="footer" style="color: #fff;text-align: center">
                    高校教材管理系统
                </div><!--end footer-->
                
        </div><!-- end top -->
        
    </body>
    
</html>