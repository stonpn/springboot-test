<table>
<#list fileList as f>
    <a href="${imgUrl}/gif/${f}">
        <img src="${imgUrl}/gif/${f}" width="200"/>
    </a>
    <a href="/file-delete.html?filename=${f}">删除</a>
</#list>
</table>