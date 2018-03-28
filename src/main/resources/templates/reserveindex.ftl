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
                            <#if status == 0>
                                <h2 class="jquery_tab_title">教材订单信息</h2>
                            <#else>
                                <h2 class="jquery_tab_title">历史订单</h2>
                            </#if>

                            <form action="/textBook/index" method="GET" enctype="multipart/form-data" id="listForm" accept-charset="UTF-8" onsubmit="document.charset='UTF-8'">
                                <#--<div class="title">
                                    &lt;#&ndash;<ul class="live_status" style="display: inline-block;>&ndash;&gt;
                                        &lt;#&ndash;<li>&ndash;&gt;
                                            <span class="label">教材名：</span>
                                            <div class="search" style="display: inline-block;">
                                                <input type="text" value="" name="title" id="title">
                                            </div>
                                        &lt;#&ndash;</li>&ndash;&gt;
                                    &lt;#&ndash;</ul>&ndash;&gt;
                                    <button type="submit" id="search" class="btn btn_input btn_primary">查找</button>
                                </div>-->
                                <div class="content">
                                    <table class="stable">
                                        <tr>
                                            <th style="width: 5%">ID</th>
                                            <th style="width: 5%">编号</th>
                                            <th style="width: 10%">教材名</th>
                                            <th style="width: 7%">作者</th>
                                            <th style="width: 7%">出版社</th>
                                            <th style="width: 10%">订阅时间</th>
                                            <th style="width: 7%">订阅老师</th>
                                            <th style="width: 7%">订阅班级</th>
                                            <th style="width: 7%">订阅数量</th>
                                            <th style="width: 7%">状态</th>
                                            <#if status == 0>
                                                <th style="width: 10%">操作</th>
                                            </#if>
                                        </tr>

                                        <tbody>
                                        <#list rlist as info>
                                        <tr data-infoId="${info.id}" data-infostatus = "${info.id}">
                                        <#--#set($current = $math.sub($page.currentPage,1))
                                        #set($i = $math.mul($!current,$!page.pageSize))
                                        #set($j =  $math.add($i,$velocityCount))
                                        <td >$j</td>-->

                                            <td class="tx_id" title="${info.id}">${info.id}</td>
                                            <td class="tx_infoName" title="${info.number}">${info.number}</td>
                                            <td class="tx_infoName" title="${tblist[info_index].name}">${tblist[info_index].name}</td>
                                            <td class="tx_infoName" title="${tblist[info_index].author}">${tblist[info_index].author}</td>
                                            <td class="tx_infoName" title="${tblist[info_index].press}">${tblist[info_index].press}</td>

                                            <td class="tx_infoName" title="${info.modified?string('yyyy-MM-dd hh:mm:ss')}">${info.modified?string('yyyy-MM-dd hh:mm:ss')}</td>
                                            <td class="tx_infoName" title="${info.tname}">${info.tname}</td><#--老师-->
                                            <td class="tx_id" title="${info.classinfo}">${info.classinfo}</td>
                                            <td class="tx_infoName" title="${info.reserves}">${info.reserves}</td>
                                            <td>
                                                <#if info.status == 0 >
                                                    待审核
                                                <#elseif info.status == 1>
                                                    已发放
                                                <#elseif info.status == 2>
                                                    已驳回
                                                <#else>
                                                    已删除
                                                </#if>
                                            </td>
                                            <#if status == 0>
                                                <td >
                                                    <a href="#" id="${info.id}" onclick="del(${info.id})">删除</a><#--老师操作-->

                                                    <a href="#" id="${info.id}" onclick="rejectR(${info.id})">驳回</a><#--管理员操作-->
                                                    <a href="#" id="${info.id}" onclick="grant(${info.id})">发放</a><#--管理员操作-->
                                                </td>
                                            </#if>
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

    <script type="text/javascript">
        function grant(id){
            $.ajax({
                url: "/reserve/edit",
                data: {
                    id: id,
                    status:1
                },
                success: function (res) {
                    if (res.code == 0) {
                        location.href = '/reserve/index?status=0';
                    } else {
                        alert(res.desc);
                    }
                },
                error: function () {
                    alert('操作失败！');
                }
            });
        }

        function rejectR(id){
            $.ajax({
                url: "/reserve/edit",
                data: {
                    id: id,
                    status:2
                },
                success: function (res) {
                    if (res.code == 0) {
                        location.href = '/reserve/index?status=0';
                    } else {
                        alert(res.desc);
                    }
                },
                error: function () {
                    alert('操作失败！');
                }
            });
        }

        function del(id){
            $.ajax({
                url: "/reserve/edit",
                data: {
                    id: id,
                    status:3
                },
                success: function (res) {
                    if (res.code == 0) {
                        location.href = '/reserve/index?status=0';
                    } else {
                        alert(res.desc);
                    }
                },
                error: function () {
                    alert('操作失败！');
                }
            });
        }
    </script>
    
</html>