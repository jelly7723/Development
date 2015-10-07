function getStyle(obj,name)
{
    if (obj.currentStyle)
    {
        return obj.currentStyle[name]
    }
    else
    {
        return getComputedStyle(obj,false)[name]
    }
}
//注意，name参数输入时要加入""引号，因为["height"]里面要加""
//obj指对象，即要获取样式的对象
//最终输出的值含有px