window.onload=function()
{
    var iBox_wrap=document.getElementById("box_wrap")
    var Img_wrap=document.getElementById("img_wrap")
    var iLeftrow=document.getElementById("leftrow")
    var iRightrow=document.getElementById("rightrow")
    iBtn=document.getElementsByTagName("li")
    index=1

    iBox_wrap.onmouseover=function()
    {
        iLeftrow.style.display="block"
        iRightrow.style.display="block"
    }

    iBox_wrap.onmouseout=function()
    {
        iLeftrow.style.display="none"
        iRightrow.style.display="none"
    }
    

    iLeftrow.onclick=function()
    {
        moveFlash(600)
        if(index==1){index=5}
            else{index-=1}
        showBtn()
    }

    iRightrow.onclick=function()
    {
        moveFlash(-600)
        if(index==5){index=1}
            else{index+=1}
        showBtn()
    }

    for(var i=0;i<iBtn.length;i++)
    {
        iBtn[i].onclick=function()
        {   
            var myindex=parseInt(this.getAttribute("index"));
            var ivalue=(myindex-parseInt(index))*-600
            moveFlash(ivalue)
            index=myindex
            showBtn()
        }
    }
}

function moveFlash(value)
{   
    var Img_wrap=document.getElementById("img_wrap")
    var timer=null;
    //遇到的第一个难点，纠结了很久终于找到了解决方法，有些变量必须要放到函数外面，因为当前的left值会不断发生变化，如果放里面，必须要想到怎么创建常变量使得itarget的值只能赋一次，因为想不到最终就放外面了，这样类似于常变量吧
    var iTarget=parseInt(getStyle(Img_wrap,"left"))+value;

    clearInterval(timer)
    timer=setInterval(function()
        {
            var current=parseInt(getStyle(Img_wrap,"left"))
            var speed=(iTarget-current)/10;
            speed=speed>0?Math.ceil(speed):Math.floor(speed)

            if(current==iTarget)
            {   
                if(iTarget==-3600)
                {
                    Img_wrap.style.left=-600+"px"
                    clearInterval(timer)
                }
                else if(iTarget==0)
                {
                    Img_wrap.style.left=-3000+"px"
                    clearInterval(timer)
                }
                else
                {
                clearInterval(timer)
                }
            }
            else
            {
                Img_wrap.style.left=current+speed+"px"
            }

        },10)
}

function showBtn()
{
    for(var i=0;i<iBtn.length;i++)
    {
        if(iBtn[i].className="on")
        {
            iBtn[i].className=" "
        }
    }

    iBtn[index-1].className="on"

}

