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
        /*opacity:0.8;!*设置背景色透明度,1为完全不透明,IE需要使用filter:alpha(opacity=80);*!*/
        /*filter:alpha(opacity=80);*/
        display: none;
        top:0;
        left:0;
        z-index:1;
        /*background: silver;*/
    }
</style>

<script type="text/javascript">

    document.onkeydown=function(event){
                     var e = event || window.event || arguments.callee.caller.arguments[0];
                     if(e && e.keyCode == 37){
                            var content = document.getElementById("big_content");
                            var i = content.firstElementChild.id;
                            var index = parseInt(i);
                            index = index - 1;
                            textImg(index);
                     }
                     if(e && e.keyCode == 39){
                         var content = document.getElementById("big_content");
                         var i = content.firstElementChild.id;
                         var index = parseInt(i);
                         index = index + 1;
                         textImg(index);
                     }
                 };

    function show(i)
    {
        var login = document.getElementById('login');
        var over = document.getElementById('over');
        login.style.display = "block";
        over.style.display = "none";
        textImg(i);
    }

    function textImg(i) {
        var index = document.getElementById(i);
        if (index == null || index == 'undefined') {

        } else {
            var src = index.firstElementChild.firstElementChild.src;
            document.getElementById("big_content").innerHTML='<a id="'+i+'" href="javascript:hide()"><img src="' + src + '" align="center" height="100%"/></a>';
        }
    }

    function hide()
    {
        var login = document.getElementById('login');
        var over = document.getElementById('over');
        login.style.display = "none";
        over.style.display = "block";
    }
</script>
<div id="login">
    <span id="big_content" align="center"></span>
</div>

