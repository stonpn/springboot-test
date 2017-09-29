<table>

<#assign i = 0>
<#list fileList as f>
    <#assign i = i + 1>
    <a id="${i}" href="http://zmj520.cn:8081/gif/sex/${f}">
        <img src="http://zmj520.cn:8081/gif/sex/${f}" width="200"/>
    </a>
    <a href="/file-sex-delete.html?filename=${f}">删除</a>
</#list>
</table>