function getClass(className,parent)
{
    var oParent=parent?document.getElementById(parent):document
    var ary=[]
    var ele=oParent.getElementsByTagName("*")
    for(var i=0;i<ele.length;i++)
    {
        if(ele[i].className==className)
        {
            ary.push(ele[i])
        }
    }
    return ary;
}

//由于IE10以下不支持getClassName()方法，所以写了该类库
//注意，关于函数第二个参数，可以不传入，不写第二个参数表示遍历该document文档的所有classname，如果传入，则必须为id，表示遍历该id下的子节点的classname，如果可以的话，尽量不要使用该方法，因为渲染较慢，浪费资源大。
//注意获取结果是一个数组，按数组方法调用。