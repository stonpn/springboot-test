<html>
<head>
    <title>威尔编程营</title>
    <meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <style>
        p {
            border-style:ridge;
            border-radius:10px;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div style="top:0;width:100%;max-width:680px;min-width:320px;margin-left: auto;margin-right:auto;margin-top: 0px;margin-bottom: 0px;height: 65px;z-index:99;">
    <div style="height:50px;background-color: orange;text-align: center;font-size: 20px;line-height: 50px;">
        <span style="color: #fff;height:40px;">我的课程</span>
    </div>
    <button type="button" onclick="osstest()">oss</button>

    <input type="file" id="f" onchange="ossget()"/>

    <form id="d" method="post" enctype="multipart/form-data">
           <input type="file" name="imgFile" onchange="ossget()"/>
        <button type="submit">tijiao</button>
    </form>


</div>
<script type="text/javascript">
    function ossget() {
        var fileData = new FormData($('#d')[0]);
        console.log(fileData);
        var url = "/gateway/save-project";
        $.ajax({
            url: url,
            type: 'POST',
            data: fileData,
            async: true,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                alert(data);
            }
        });
    }
</script>
</body>
</html>