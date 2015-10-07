/**
 * Created by Administrator on 2015/9/19.
 */

//绘制圆和弧线

window.onload= function () {
    var canvas = document.getElementById("canvas");
    //canvas.width=1024;
    //canvas.height=768;
    if (canvas.getContext("2d")) {
        //引入接口，据说是最关键的一步
        var context = canvas.getContext("2d");
    }
    else {
        alert("浏览器版本过低，不支持canvas属性，请使用现代浏览器。");
    }

    context.lineWidth=5
    context.strokeStyle="orange"

    //绘制弧线
    context.arc(300,300,200,0.5,2*Math.PI,false)
    //前两个参数表示圆心的位置，x坐标和y坐标，第三个参数设置半径radius，第四个参数表示起始位置(单位是PI)，
    // 第五个参数指终止位置，还有隐藏的第六个参数，默认是false，表示顺时针绘制，显式设置为true则表示逆时针
    context.stroke()
    //注意，上面也可以使用beginPath()与closePath(),当路径不封闭使用path则会自动把路径封闭起来，即连接首尾

    //另外，beginPath()和closePath()两者不一定同时出现，begin指的是重新开始一段路径，而close则是关闭路径并
    //封闭，但是可以不使用close，直接连续使用两个begin,当遇到第二个begin时系统会自动结束之前路径。

}