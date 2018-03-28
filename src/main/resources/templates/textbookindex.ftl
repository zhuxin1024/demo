<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title>高校教材管理系统</title>
        <link rel="stylesheet" href="/css/style_all.css" type="text/css" media="screen" />
        <link rel="stylesheet" type="/text/css"  href="css/table.css">
        

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
        <script type='text/javascript' src='/ueditor1_2_2_0-utf8-php/editor_config.js'></script>
        <#--<script type='text/javascript' src='/js/custom.js'></script>-->

        <script type='text/javascript' src='/js/textbook/index.js'></script>
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
                       欢迎 <a href="">${userName}</a>
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
                            <h2 class="jquery_tab_title">教材信息查询</h2>

                            <form action="/textBook/index" method="GET" enctype="multipart/form-data" id="listForm" accept-charset="UTF-8" onsubmit="document.charset='UTF-8'">
                                <div class="title">
                                    <#--<ul class="live_status" style="display: inline-block;>-->
                                        <#--<li>-->
                                            <span class="label">教材名：</span>
                                            <div class="search" style="display: inline-block;">
                                                <input type="text" value="" name="title" id="title">
                                            </div>
                                        <#--</li>-->
                                    <#--</ul>-->
                                    <button type="submit" id="search" class="btn btn_input btn_primary">查找</button>
                                </div>
                                <div class="content">
                                    <table class="stable">
                                        <tr>
                                            <th style="width: 5%">ID</th>
                                            <th style="width: 10%">编号</th>
                                            <th style="width: 15%">教材名</th>
                                            <th style="width: 10%">作者</th>
                                            <th style="width: 10%">出版社</th>
                                            <th style="width: 10%">库存</th>
                                            <th style="width: 10%">操作</th>
                                        </tr>

                                        <tbody>
                                        <#list tblist as info>
                                        <tr data-infoId="${info.id}" data-infostatus = "${info.id}">
                                        <#--#set($current = $math.sub($page.currentPage,1))
                                        #set($i = $math.mul($!current,$!page.pageSize))
                                        #set($j =  $math.add($i,$velocityCount))
                                        <td >$j</td>-->
                                            <td class="tx_id" title="${info.id}">${info.id}</td>
                                            <td class="tx_infoName" title="${info.number}">${info.number}</td>
                                            <td class="tx_infoName" title="${info.name}">${info.name}</td>
                                            <td class="tx_id" title="${info.author}">${info.author}</td>
                                            <td class="tx_infoName" title="${info.press}">${info.press}</td>
                                            <td class="tx_infoName" title="${stocklist[info_index]}">${stocklist[info_index]}</td> <#--库存-->
                                            <td >
                                                <#if userType == '1'>
                                                    <a href="/textBook/info.acedittion?id=${info.id}">查看</a>
                                                    <a href="/textBook/edit?id=${info.id}" class="" >编辑</a>
                                                <#elseif userType == '2'>
                                                    <a href="/textBook/info.acedittion?id=${info.id}">查看</a>
                                                    <#--<a href="/textBook/edit?id=${info.id}" class="" >订阅</a>-->
                                                <#else>
                                                    <a href="/textBook/info.acedittion?id=${info.id}">查看</a>
                                                </#if>
                                            </td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                    <div class="pagination" data-form="listForm">

                                    </div>
                                </div>
                            </form>

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