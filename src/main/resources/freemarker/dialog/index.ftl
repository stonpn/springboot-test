<form action="/dialog/save">
    <input name="dialog" type="text" width="100%"/>
    <button type="submit">添加</button>
</form>
<br/>
<table>
<#list list as f>
    <tr>
        <td>${f.dialog}</td>
        <td width="100"><a href="/dialog/delete?id=${f.id}">删除</a></td>
    </tr>
</#list>
</table>