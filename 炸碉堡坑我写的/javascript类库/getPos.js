function getPos(oEv)
{
    var oClientX=oEv.clientX;
    var oClientY=oEv.clientY;
    var oScrollTop=document.documentElement.scrollTop||document.body.scrollTop;
    var oScrollLeft=document.documentElement.scrollLeft||document.body.scrollLeft;

    return {x:oClientX+oScrollLeft+"px",y:oClientY+oScrollTop+"px"}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//pos函数的作用是获取当前鼠标的位置，分别为client加上scroll的位置                                                                     //
//oEv的全称为oEvent，为避免某些未知错误所以写成oEv                                                                              //
//使用了json的写法，关于如何调用函数，需要注意的是，在调用函数的环境中，必须要考虑到事件对象的兼容，                                                         //

//即比如说 function(ev)  { var oEvent=ev||event;  var pos=getPos(oEvent); var client_x=pos.x; var client_y=pos.y} //

//上述就是关于getPos函数的具体用法以及注意事项                                                                                   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
