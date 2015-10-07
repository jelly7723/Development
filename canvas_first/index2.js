/**
 * Created by Administrator on 2015/9/19.
 */
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

    //之所以使用beginPath(),是因为canvas是基于状态的，如果不用路径，则后面的样式会重写前面的
    context.beginPath()
    context.moveTo(100, 100);
    context.lineTo(700, 700);
    context.lineTo(100, 700);
    context.lineTo(100, 100);
    context.closePath()

    context.strokeStyle="red"
    context.lineWidth=5
    context.stroke()

    context.beginPath()
    context.moveTo(300,200)
    context.lineTo(500,400)
    context.closePath()

    context.strokeStyle="black"
    context.stroke()
}