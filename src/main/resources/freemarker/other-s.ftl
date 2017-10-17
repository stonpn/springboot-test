<table>
<#list fileList as f>
    <a href="${imgUrl}/other/sex/${f}">
        <img src="${imgUrl}/other/sex/${f}" width="200"/>
    </a>
    <a href="/file-sex-delete.html?filename=${f}">删除</a>
</#list>
</table>