window.onload=function(){
    var iprev=document.getElementById("prev_btn");
    var inext=document.getElementById("next_btn");
    var ilist=document.getElementById("list_scroll");
    var btn=document.getElementById("nav").getElementsByTagName("li");
    var index=1;
    var p=false;
    var timer=null;
    var icontainer=document.getElementById("i");


//img跳转脚本，无论是arrow还是nav都是调用此函数
function animate(offset){

    var time=300;
    var interval=10;
    var speed=offset/(time/interval);
    var nowleft=parseInt(ilist.style.left)+offset+"px";

//动画脚本
    function go(){
        if( (speed>0&&parseInt(ilist.style.left)<parseInt(nowleft) )||( speed<0&&( parseInt(ilist.style.left)>parseInt(nowleft) ) ) )
        {
        p=true;
        ilist.style.left=parseInt(ilist.style.left)+speed+"px";
        setTimeout(go, interval);
        }
        else{
            p=false;
                if(parseInt(ilist.style.left)>-600){
        ilist.style.left=-3000+"px";
    }
                if(parseInt(ilist.style.left)<-3000){
        ilist.style.left=-600+"px";     
    }
        }
    }
    go();


}

//nav下面的小图标相应变亮脚本
function show_btn(){
    
    for(i=0;i<btn.length;i++)  
    {
        if(btn[i].className=="on")
        {
            btn[i].className="";
            break;
        }
    }
    

    btn[index-1].className="on";

}

//next 分别调用animate show_btn函数
inext.onclick=function(){
    if (index==5) {
        index=1;
    }
    else{
    index+=1;
    }
    show_btn();

    if(p==false){
    animate(-600);
    }
}

//prev 分别调用animate show_btn函数
iprev.onclick=function(){
    if (index==1) {
        index=5;
    }
    else{
    index-=1;
    }
    show_btn();

    if(p==false){
    animate(600);
    }
}


//较难，此部分函数主要应用于btn点击的跳转
//暂时还不能理解for循环调用onclick
for(var i=0;i<btn.length;i++){
    btn[i].onclick=function(){
        var myindex=parseInt(this.getAttribute("index"));
        if (this.className=="on") {
            return;
        };
        offset=-600*(myindex-index);
        animate(offset);
        index=myindex;
        show_btn();
        }
    }

//自动轮播动画
function play(){
    timer=setInterval(function(){
    inext.onclick()},1000)
    }

function stop(){
    clearInterval(timer);
}

//问题来了，为什么onmouseover引用的函数不需要加括号？
//加括号表示的是引用函数的结果，不加函数表示引用函数对象。。javascript高级程序设计有，忘了
    icontainer.onmouseover=stop;
    icontainer.onmouseout=play;
    play();
}


