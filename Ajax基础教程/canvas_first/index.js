/**
 * Created by Administrator on 2015/9/19.
 */
window.onload= function () {
    var canvas=document.getElementById("canvas");
    //canvas.width=1024;
    //canvas.height=768;
    if(canvas.getContext("2d")) {
        //引入接口，据说是最关键的一步
        var context = canvas.getContext("2d");
    }
    else{
        alert("浏览器版本过低，不支持canvas属性，请使用现代浏览器。");
    }

    //开始绘制
    context.moveTo(100,100);
    context.lineTo(700,700);
    context.lineTo(100,700);
    context.lineTo(100,100);

    //1、stroke()方法是用来绘制线条
    /*
    context.lineWidth=5;    设置线条的宽度
    context.strokeStyle="orange";   设置线条样式
    context.stroke();
    */

    //2、fill()方法，填充
    /*
    context.fillStyle="green"
    context.fill()
    */

    //也可以两种方法同时使用，同时使用表示填充并且有边框
}