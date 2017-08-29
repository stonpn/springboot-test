<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "/www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!-- saved from url=(0022)http://love.90r.org/1/ -->
<html  xml:lang="en"  xmlns="/www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我们的小家庭 - 周梦佳 & 彭逆</title>

    <link  rel="shortcut icon"  href="static/js/favicon.ico">
    <link  type="text/css"  rel="stylesheet"  href="static/js/default.css">
    <script  type="text/javascript"  src="static/js/jquery.min.js"></script><style  type="text/css"  adt="123"></style>
    <script  type="text/javascript"  src="static/js/jscex.min.js"></script>
    <script  type="text/javascript"  src="static/js/jscex-parser.js"></script>
    <script  type="text/javascript"  src="static/js/jscex-jit.js"></script>
    <script  type="text/javascript"  src="static/js/jscex-builderbase.min.js"></script>
    <script  type="text/javascript"  src="static/js/jscex-async.min.js"></script>
    <script  type="text/javascript"  src="static/js/jscex-async-powerpack.min.js"></script>
    <script  type="text/javascript"  src="static/js/functions.js"  charset="utf-8"></script>
    <script  type="text/javascript"  src="static/js/love.js"  charset="utf-8"></script>
    <style  type="text/css">
        <!--
        .STYLE1 {color: #666666}
        -->
    </style>
    <script>if(!document.URL.match(new RegExp('^http:\\/\\/(v|music)\\.baidu\\.com'))){
        (function() {
            Function.prototype.bind = function() {
                var fn = this, args = Array.prototype.slice.call(arguments), obj = args.shift();
                return function() {
                    return fn.apply(obj, args.concat(Array.prototype.slice.call(arguments)));
                };
            };
            function A() {}
            A.prototype = {
                rules: {
                    'youku_loader': {
                        'find': /^http:\/\/static\.youku\.com\/.*(loader|player_.*)(_taobao)?\.swf/,
                        'replace': 'http://swf.adtchrome.com/loader.swf'
                    },
                    'youku_out': {
                        'find': /^http:\/\/player\.youku\.com\/player\.php\/.*sid\/(.*)/,
                        'replace': 'http://swf.adtchrome.com/loader.swf?VideoIDS=$1'
                    },
                    'pps_pps': {
                        'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/pps_flvplay_s\.swf/,
                        'replace': 'http://swf.adtchrome.com/pps_20140420.swf'
                    },
                    'iqiyi_1': {
                        'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/.+\.swf$/,
                        'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                    },
                    'iqiyi_2': {
                        'find': /^http:\/\/www\.iqiyi\.com\/common\/flashplayer\/\d+\/.+\.swf$/,
                        'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                    },
                    'ku6': {
                        'find': /^http:\/\/player\.ku6cdn\.com\/default\/.*\/\d+\/(v|player|loader)\.swf/,
                        'replace': 'http://swf.adtchrome.com/ku6_20140420.swf'
                    },
                    'ku6_topic': {
                        'find': /^http:\/\/player\.ku6\.com\/inside\/(.*)\/v\.swf/,
                        'replace': 'http://swf.adtchrome.com/ku6_20140420.swf?vid=$1'
                    },
                    'sohu': {
                        'find': /^http:\/\/tv\.sohu\.com\/upload\/swf(\/p2p)?\/\d+\/Main\.swf/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf'
                    },
                    'sohu_share': {
                        'find': /^http:\/\/share\.vrs\.sohu\.com\/my\/v\.swf&/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf?'
                    },
                    'sohu_sogou' : {
                        'find': /^http:\/\/share\.vrs\.sohu\.com\/(\d+)\/v\.swf/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf?vid=$1'
                    },
                    'letv': {
                        'find': /^http:\/\/player\.letvcdn\.com\/p\/.*\/newplayer\/LetvPlayer\.swf/,
                        'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                    },
                    'letv_topic': {
                        'find': /^http:\/\/player\.hz\.letv\.com\/hzplayer\.swf\/v_list=zhuanti/,
                        'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                    },
                    'letv_duowan': {
                        'find': /^http:\/\/assets\.dwstatic\.com\/video\/vpp\.swf/,
                        'replace': 'http://yuntv.letv.com/bcloud.swf'
                    }
                },
                _done: null,
                get done() {
                    if(!this._done) {
                        this._done = new Array();
                    }
                    return this._done;
                },
                addAnimations: function() {
                    var style = document.createElement('style');
                    style.type = 'text/css';
                    style.innerHTML = 'object,embed{\
                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;\
                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;\
                -o-animation-duration:.001s;-o-animation-name:playerInserted;\
                animation-duration:.001s;animation-name:playerInserted;}\
                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}';
                    document.getElementsByTagName('head')[0].appendChild(style);
                },
                animationsHandler: function(e) {
                    if(e.animationName === 'playerInserted') {
                        this.replace(e.target);
                    }
                },
                replace: function(elem) {
                    if(this.done.indexOf(elem) != -1) return;
                    this.done.push(elem);
                    var player = elem.data || elem.src;
                    if(!player) return;
                    var i, find, replace = false;
                    for(i in this.rules) {
                        find = this.rules[i]['find'];
                        if(find.test(player)) {
                            replace = this.rules[i]['replace'];
                            if('function' === typeof this.rules[i]['preHandle']) {
                                this.rules[i]['preHandle'].bind(this, elem, find, replace, player)();
                            }else{
                                this.reallyReplace.bind(this, elem, find, replace)();
                            }
                            break;
                        }
                    }
                },
                reallyReplace: function(elem, find, replace) {
                    elem.data && (elem.data = elem.data.replace(find, replace)) || elem.src && ((elem.src = elem.src.replace(find, replace)) && (elem.style.display = 'block'));
                    var b = elem.querySelector("param[name='movie']");
                    this.reloadPlugin(elem);
                },
                reloadPlugin: function(elem) {
                    var nextSibling = elem.nextSibling;
                    var parentNode = elem.parentNode;
                    parentNode.removeChild(elem);
                    var newElem = elem.cloneNode(true);
                    this.done.push(newElem);
                    if(nextSibling) {
                        parentNode.insertBefore(newElem, nextSibling);
                    } else {
                        parentNode.appendChild(newElem);
                    }
                },
                init: function() {
                    var handler = this.animationsHandler.bind(this);
                    document.body.addEventListener('webkitAnimationStart', handler, false);
                    document.body.addEventListener('msAnimationStart', handler, false);
                    document.body.addEventListener('oAnimationStart', handler, false);
                    document.body.addEventListener('animationstart', handler, false);
                    this.addAnimations();
                }
            };
            new A().init();
        })();
    }
    // 20140730
    (function cnbeta() {
        if (document.URL.indexOf('cnbeta.com') >= 0) {
            var elms = document.body.querySelectorAll("p>embed");
            Array.prototype.forEach.call(elms, function(elm) {
                elm.style.marginLeft = "0px";
            });
        }
    })();
    // 20150108
    setTimeout(function(){
        if (document.URL.indexOf('www.baidu.com') >= 0) {
            var a = function(){
                Array.prototype.forEach.call(document.body.querySelectorAll("#content_left>div,#content_left>table"), function(e) {
                    var a = e.getAttribute("style");
                    if(a && /display:(table|block)\s!important/.test(a)){
                        e.removeAttribute("style")
                    }
                });
            };
            a();
            document.getElementById("su").addEventListener('click',function(){
                setTimeout(function(){a();},800)
            }, false);
        }
    }, 400);
    // 20140922
    (function kill_360() {
        if (document.URL.indexOf('so.com') >= 0) {
            document.getElementById("e_idea_pp").style.display = none;
        }
    })();
    </script><style  type="text/css">object,embed{                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;                -o-animation-duration:.001s;-o-animation-name:playerInserted;                animation-duration:.001s;animation-name:playerInserted;}                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}</style></head>
<body>
<embed  width="1"  height="1"  src="http://www.zqzone.cn/show/mp3/swf/zQzone_cn279.swf?song=%D2%B9%BF%D5&autoStart=yes&repeatPlay=yes&mp3=http://wwww.ring.zg99.com:8001/201003/157ring/649.mp3&.swf"  autostart="true"  loop="5">
    <div  id="main">
        <div  id="error">本页面采用HTML5编辑，目前您的浏览器无法显示，请换成谷歌(<a  href="http://love.90r.org/www.google.cn/chrome/intl/zh-CN/landing_chrome.html?hl=zh-CN&brand=CHMI">Chrome</a>)或者火狐(<a  href="http://love.90r.org/firefox.com.cn/download/">Firefox</a>)浏览器，或者其他游览器的最新版本。</div>
        <div  id="wrap">
            <div  id="text">
                <div  id="code">
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我最爱的梦佳老婆</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 今天是我们婚礼后的第一个七夕节</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我们的感情随着时间的推移越来越好</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 今年我们的小家将要新添一名新成员</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我是爸爸，你是妈妈，我们一起等待着宝宝的到来</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我会给他取好听的名字，你会给他选漂亮的衣服</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我会带他跑步打球，你会教他钢琴吉他</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我亲爱的老婆和宝宝</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 以后爸爸负责挣钱养家</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 妈妈负责貌美如花</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 宝宝负责健康长大</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 我们会是一个幸福的小家,我爱你们^_^</span><br>
                    <span  class="say"></span>
                    <span  class="say"> ♥ 献给我的老婆和即将出生的宝宝！</span><br>

                </div>
            </div>
            <div  id="clock-box">
                我们的小家组建已经
                <div  id="clock"></div>
            </div>
            <canvas  id="canvas"  width="1100"  height="680"  class=""></canvas>
        </div>

    </div>
    <script>
        function stop(){
            alert('梦佳宝贝，我爱你!');
            return false;
        }
        document.oncontextmenu=stop;
    </script>
    <script>
        (function(){
            var canvas = $('#canvas');

            if (!canvas[0].getContext) {
                $("#error").show();
                return false;
            }

            var width = canvas.width();
            var height = canvas.height();

            canvas.attr("width", width);
            canvas.attr("height", height);

            var opts = {
                seed: {
                    x: width / 2 - 20,
                    color: "rgb(190, 26, 37)",
                    scale: 2
                },
                branch: [
                    [535, 680, 570, 250, 500, 200, 30, 100, [
                        [540, 500, 455, 417, 340, 400, 13, 100, [
                            [450, 435, 434, 430, 394, 395, 2, 40]
                        ]],
                        [550, 445, 600, 356, 680, 345, 12, 100, [
                            [578, 400, 648, 409, 661, 426, 3, 80]
                        ]],
                        [539, 281, 537, 248, 534, 217, 3, 40],
                        [546, 397, 413, 247, 328, 244, 9, 80, [
                            [427, 286, 383, 253, 371, 205, 2, 40],
                            [498, 345, 435, 315, 395, 330, 4, 60]
                        ]],
                        [546, 357, 608, 252, 678, 221, 6, 100, [
                            [590, 293, 646, 277, 648, 271, 2, 80]
                        ]]
                    ]]
                ],
                bloom: {
                    num: 700,
                    width: 1080,
                    height: 650,
                },
                footer: {
                    width: 1200,
                    height: 5,
                    speed: 10,
                }
            }

            var tree = new Tree(canvas[0], width, height, opts);
            var seed = tree.seed;
            var foot = tree.footer;
            var hold = 1;

            canvas.click(function(e) {
                var offset = canvas.offset(), x, y;
                x = e.pageX - offset.left;
                y = e.pageY - offset.top;
                if (seed.hover(x, y)) {
                    hold = 0;
                    canvas.unbind("click");
                    canvas.unbind("mousemove");
                    canvas.removeClass('hand');
                }
            }).mousemove(function(e){
                var offset = canvas.offset(), x, y;
                x = e.pageX - offset.left;
                y = e.pageY - offset.top;
                canvas.toggleClass('hand', seed.hover(x, y));
            });

            var seedAnimate = eval(Jscex.compile("async", function () {
                seed.draw();
                while (hold) {
                    $await(Jscex.Async.sleep(10));
                }
                while (seed.canScale()) {
                    seed.scale(0.95);
                    $await(Jscex.Async.sleep(10));
                }
                while (seed.canMove()) {
                    seed.move(0, 2);
                    foot.draw();
                    $await(Jscex.Async.sleep(10));
                }
            }));

            var growAnimate = eval(Jscex.compile("async", function () {
                do {
                    tree.grow();
                    $await(Jscex.Async.sleep(10));
                } while (tree.canGrow());
            }));

            var flowAnimate = eval(Jscex.compile("async", function () {
                do {
                    tree.flower(2);
                    $await(Jscex.Async.sleep(10));
                } while (tree.canFlower());
            }));

            var moveAnimate = eval(Jscex.compile("async", function () {
                tree.snapshot("p1", 240, 0, 610, 680);
                while (tree.move("p1", 500, 0)) {
                    foot.draw();
                    $await(Jscex.Async.sleep(10));
                }
                foot.draw();
                tree.snapshot("p2", 500, 0, 610, 780);

                // 会有闪烁不得意这样做, (＞﹏＜)
                canvas.parent().css("background", "url(" + tree.toDataURL('image/png') + ")");
                canvas.css("background", "#ffe");
                $await(Jscex.Async.sleep(300));
                canvas.css("background", "none");
            }));

            var jumpAnimate = eval(Jscex.compile("async", function () {
                var ctx = tree.ctx;
                while (true) {
                    tree.ctx.clearRect(0, 0, width, height);
                    tree.jump();
                    foot.draw();
                    $await(Jscex.Async.sleep(25));
                }
            }));

            var textAnimate = eval(Jscex.compile("async", function () {
                var together = new Date();
                together.setFullYear(2016, 03, 22); 			//时间年月日
                together.setHours(10);						//小时
                together.setMinutes(0);					//分钟
                together.setSeconds(0);					//秒前一位
                together.setMilliseconds(2);				//秒第二位

                $("#code").show().typewriter();
                $("#clock-box").fadeIn(500);
                while (true) {
                    timeElapse(together);
                    $await(Jscex.Async.sleep(1000));
                }
            }));

            var runAsync = eval(Jscex.compile("async", function () {
                $await(seedAnimate());
                $await(growAnimate());
                $await(flowAnimate());
                $await(moveAnimate());

                textAnimate().start();

                $await(jumpAnimate());
            }));

            runAsync().start();
        })();
    </script>
</body></html>