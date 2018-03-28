<#macro showPage $page>
    <#if($page.totalCount > 0)>
        <#assign curPage = $page.currentPage>
        <#assign innerNum = 2> <#--省略号中间显示的分页条目数-->
        <#assign edgeNum = 2> <#--两侧显示的首尾分页的条目数-->
        <#assign halfNum = $math.ceil($math.div(innerNum,2))>
        <#assign limit = $page.totalPage - innerNum>
        <#assign startPage = 0>
        <#assign endPage = $math.min(innerNum,$page.totalPage)>
        <#if($math.sub($curPage,1)>$halfNum)>
            #set($startPage = $math.max($math.min($math.sub($math.sub($curPage,1),$halfNum),$limit),0))
            #set($endPage=$math.min($math.add($math.sub($curPage,1),$halfNum),$!page.totalPage))
        </#if>

        #if($curPage > 1) ##上一页
            #set($prePage = $curPage - 1)
            <a class="prev" href="#" onclick="goToPageA('$prePage',event)">
                <img src="../../misc/img/arrow_left.png"  onclick="goToPageA('$prePage',event)"/>
            </a>
        #else
            <span class="current prev">
                <img src="../../misc/img/arrow_left.png"/>
            </span>
        #end

        #if($startPage>0 && $edgeNum>0)##左侧显示列表页
            #set($end = $math.min($edgeNum,$startPage))
            #foreach($i in [0..$math.sub($end,1)])
                #set($j = $i+1)
                #if($j == $curPage)
                    <span class="current">$curPage</span>##显示当前页号
                #else
                    <a href="#" class="pageNum" onclick="goToPageA('$j',event)">$j</a>
                #end

            #end
            #if($edgeNum<$startPage)
                <span>...</span>
            #end
        #end

        #foreach($i in [$startPage..$math.sub($endPage,1)]) ##内部连续页
            #set($j = $i+1)
            #if($j == $curPage)
                <span class="current">$curPage</span>##显示当前页号
            #else
                <a href="#" class="pageNum" onclick="goToPageA('$j',event)">$j</a>
            #end
        #end

        #if($endPage<$!page.totalPage && $edgeNum>0) ##右侧列表页
            #if($math.sub($!page.totalPage,$edgeNum)>$endPage)
                <span>...</span>
            #end
            #set($begin = $math.max($math.sub($!page.totalPage,$edgeNum),$endPage))
            #foreach($i in [$begin..$math.sub($!page.totalPage,1)])
                #set($j = $i+1)
                #if($j == $curPage)
                    <span class="current">$curPage</span>##显示当前页号
                #else
                    <a href="#" class="pageNum" onclick="goToPageA('$j',event)">$j</a>
                #end
            #end
        #end

        #if($curPage<$page.totalPage)
            #set($nextPage = $curPage + 1)
            <a class="next" href="#" onclick="goToPageA('$nextPage',event)">
                <img src="../../misc/img/arrow_right.png" onclick="goToPageA('$nextPage',event)"/>
            </a>
        #else
            <span class="current next"><img src="../../misc/img/arrow_right.png"/></span>
        #end
        #*<span class="total">共$!{page.totalPage}页</span>*#
        <span class="skip">
            <input type="hidden" value="$!page.currentPage" name="currentPage" id="currentPage">
            <input type="hidden" value="$!page.pageSize" name="pageSize" id="pageSize">
            <input name="totalPage" type="hidden" value="$!{page.totalPage}"/>
            到<input name="toPage" id="toPage" type="text" size="2">页
            <input type="button" value="确定" onclick="goToPage(event)" class="btn btn_default">
        </span>
    #else
        <p class="empty_tips">暂无数据</p>
    </#if>
</#macro>
