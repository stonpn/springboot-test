<table>
<#list fileList as f>
    <a href="http://zmj520.cn:8081/gif/${f}">
        <img src="${imgUrl}/gif/${f}" width="200"/>
    </a>
    <a href="/file-delete.html?filename=${f}">删除</a>
</#list>
</table>