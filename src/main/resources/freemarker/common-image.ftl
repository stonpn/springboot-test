<#include "public/common.ftl"/>
<table>
    <#list fileList as f>
        <span id="${f_index}">
            <a href="javascript:show(${f_index})">
            <#--<a href="${imgUrl}/other/${f}">-->
                <img src="${imgUrl}/other/${f}" width="200"/>
            </a>
            <a href="/file-delete.html?filename=${f}">删除</a>
        </span>
    </#list>
</table>