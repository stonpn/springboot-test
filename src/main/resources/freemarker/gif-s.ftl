<#include "public/common.ftl"/>
<div id="over" style="display: block">
    <table>
    <#list fileList as f>
        <span id="${f_index}">
                <a href="javascript:show(${f_index})">
                <#--<a href="${imgUrl}/other/${f}">-->
                    <img src="${imgUrl}/gif/sex/${f}" width="200"/>
                </a>
                <a href="/file-sex-delete.html?filename=${f}">删除</a>
            </span>
    </#list>
    </table>
</div>