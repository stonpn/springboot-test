<style type="text/css">
    #login
    {
        display:none;
        height:100%;
        width:100%;
        position:absolute;
        z-index:2;/*个人理解为层级关系,由于这个节点要在顶部显示,所以这个值比其余节点的都大*/
        background: white;
    }
    #over
    {
        width: 100%;
        height: 100%;
        opacity:0.8;/*设置背景色透明度,1为完全不透明,IE需要使用filter:alpha(opacity=80);*/
        filter:alpha(opacity=80);
        display: none;
        position:absolute;
        top:0;
        left:0;
        z-index:1;
        background: silver;
    }
</style>

<script type="text/javascript">

    function show(i)
    {
        var login = document.getElementById('login');
        var over = document.getElementById('over');
        login.style.display = "block";
        over.style.display = "block";
        var index = document.getElementById(i);
        var src = index.firstElementChild.firstElementChild.src;
        document.getElementById("big_content").innerHTML='<a href="javascript:hide()"><img src="' + src + '" align="center"/></a>';
    }
    function hide()
    {
        var login = document.getElementById('login');
        var over = document.getElementById('over');
        login.style.display = "none";
        over.style.display = "none";
    }
</script>
<div id="login">
    <div id="big_content"></div>
</div>

<div id="over"></div>