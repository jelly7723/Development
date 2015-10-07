window.onload=function(){
    var ml=document.getElementById("scr2");
    ml.onmouseover=function(){
         starmove(0);
    }
    ml.onmouseout=function(){
        starmove(-57);
    }
}
var timer=null;

function starmove(iTarget){
        clearInterval(timer);
        var ve=document.getElementById("scr");
        var speed=0;
      if (iTarget>ve.offsetTop) {
            speed=1;
        }
        else{
            speed=-1;
        };
    
        timer=setInterval(function(){
        
       { if (ve.offsetTop==iTarget) {
            clearInterval(timer);
        }
        else{
        ve.style.top=ve.offsetTop+speed+'px';
        }
}
    }, 30)
}