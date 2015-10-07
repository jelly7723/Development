var addballs=[]
window.onload= function () {
    var canvas=document.getElementById("canvas")
    canvas.width="1500"
    canvas.height="800"
    var context=canvas.getContext("2d")
    colors_v = ["#33B5E5","#0099CC","#AA66CC","#9933CC","#99CC00","#669900","#FFBB33","#FF8800","#FF4444","#CC0000"]

    //定义并创建一个二维数组，暂时先定义一维，稍后接着定义第二维
    number_model=[]

    //定义每个数字下的所有圆的相关属性，如大小或者间距
    var radius_v=8     //圆的半径
    var inter_v=2     //这个是每个圆之间间距

    //定义Handle这个对象，并且把给它加上prototype
    function Handle() {
    }

    Handle.prototype={

        //重写构造函数
        constructor:Handle,

        //转换格式,点阵图变成xy坐标图
        change:function(){
            for (var i = 0; i < number.length; i++) {
                //删除之前定义二维数组时产生的垃圾值
                number_model[i]=[]

                for (var j = 0; j < number[i].length; j++) {

                    for (var k = 0; k < number[i][j].length; k++) {
                        //关于这个if判断，可以不写，但是写了之后就可以把那些没意义的对象{x:0,y:0}扔掉
                        if( parseInt(number[i][j][k] * (k + 1))+parseInt(number[i][j][k] * (j + 1))!=0) {
                            //push方法把对象推进去
                            number_model[i].push({x: parseInt(number[i][j][k] * (k + 1)), y: parseInt(number[i][j][k] * (j + 1))})
                        }
                    }

                }
            }
        },

        //输入绘制的数字
        num:function(value,start_v,bool) {

            for (var i = 0; i < number_model[value].length; i++) {
                this.position_v(number_model[value][i],start_v,bool)
            }
        },

        //把相关坐标计算出来，并且传给draw方法进行绘制
        position_v:function(obj,start_v,bool){
            return_v={
                x:start_v.x*radius_v*2+radius_v*(2*obj.x-1)+inter_v*obj.x,
                y:start_v.y*radius_v*2+radius_v*(2*obj.y-1)+inter_v*obj.y}

            this.draw(return_v,bool)
        },

        //绘制
        draw:function(obj,bool) {

            context.beginPath()
            context.arc(obj.x, obj.y, radius_v, 0, 2*Math.PI, false)
            context.closePath()

            //设置圆的相同或者不同颜色
            if(bool){
                var ran=parseInt(Math.random()*10)
                context.fillStyle=colors_v[ran]
                obj.color=colors_v[ran]
                obj.v_x= Math.pow(-1, Math.ceil(Math.random() * 1000)) * Math.random()*10
                obj.v_y=-4
                obj.a=1.5 + Math.random()
                obj.v_z=Math.pow(-1, Math.ceil(Math.random() * 1000)) * Math.random()*10

                addballs.push(obj)
            }
            else{
                context.fillStyle="rgb(0,102,153)"
                context.fill()
            }

        },

        //更新每一个小球的位置
        update:function(obj)
        {

            obj.x +=obj.v_x
            obj.v_y += obj.a
            obj.y +=obj.v_y
            //判断，当碰触桌面y值速度方向相反，并且速度损耗
            if(800-obj.y<=8){
                obj.y=800-8
                obj.v_x=obj.v_x*0.8
                obj.v_y=-obj.v_y*0.67
            }
            //判断，当
            if(obj.v_y<1){
                obj.v_x=obj.v_z
            }


        },


        draw_update:function(obj) {

            context.beginPath()

            context.arc(obj.x, obj.y, radius_v, 0, 2 * Math.PI, false)

            context.closePath()

            context.fillStyle=obj.color
            context.fill()
        }



    }


    //创建两个对象
    var handle=new Handle()
    var handle2=new Handle()

    //把点阵图的格式转换成xy对象组
    handle.change()
    handle2.change()

    function conbineStr(ary,obj){
        for(var i=0;i<ary.length;i++){
            if(ary[i].toString().length<2){
                obj.time_string+="0"+ary[i].toString()
            }
            else{
                obj.time_string+=ary[i].toString()
            }
        }
    }



    function changeToArray(obj) {
        for(var i=0;i<obj.time_string.length;i++){
            obj.time_array.push(obj.time_string.slice(i,i+1))
        }
    }


    //判断时间发生了改变，闭包,这个是before时间
    function be_flag() {
        var before = new Date()
        var time_before = [before.getHours(),before.getMinutes(),before.getSeconds()]
        time_before_obj={time_string:"",time_array:[]}
        before_flag=0

        conbineStr(time_before,time_before_obj)
        changeToArray(time_before_obj)

        for(var i=0;i<time_before_obj.time_array.length;i++){
            before_flag+=parseInt(time_before_obj.time_array[i]*Math.pow(10,(5-i)))
        }


    }

    be_flag()

    var timer=null

    function animation() {
        clearTimeout(timer)

        //刷新画布，解决重影问题
        context.clearRect(0,0,1500,800)

        var now = new Date()
        var time_now = [now.getHours(),now.getMinutes(),now.getSeconds()]
        var time_now_obj={time_string:"",time_array:[]}



        //调用函数把时间nuber拼合起来并装成字符串
        conbineStr(time_now,time_now_obj)

        //之后，还要把字符串转成数组
        changeToArray(time_now_obj)


        //时钟格式转化完毕，开始绘制数字，注意和前面的draw有区别，draw只是绘制一个球
        interval=10     //每个数字之间的间距
        begin_y=10      //数字的起始位置
        begin_x=4

        handle.num(time_now_obj.time_array[0],{x:0*interval+begin_x,y:begin_y},false)
        handle.num(time_now_obj.time_array[1],{x:1*interval+begin_x,y:begin_y},false)
        handle.num(10,{x:2*interval+begin_x,y:begin_y})//这个是冒号
        handle.num(time_now_obj.time_array[2],{x:3*interval+begin_x,y:begin_y},false)
        handle.num(time_now_obj.time_array[3],{x:4*interval+begin_x,y:begin_y},false)
        handle.num(10,{x:5*interval+begin_x,y:begin_y})//这个是冒号
        handle.num(time_now_obj.time_array[4],{x:6*interval+begin_x,y:begin_y},false)
        handle.num(time_now_obj.time_array[5],{x:7*interval+begin_x,y:begin_y},false)


        /*handle2.num(time_now_obj.time_array[5], {x: 7 * interval + begin_x, y: begin_y}, true,{v_x:2,v_y:3,a:4})
        handle2.num(time_now_obj.time_array[4], {x: 6 * interval + begin_x, y: begin_y}, true,{v_x:2,v_y:3,a:4})
*/
        //判断时间是否改变，并且把改变的值显示出来，这个是now时间
        var now_flag=0
        for(var i=0;i<time_now_obj.time_array.length;i++)
        {
             now_flag+=parseInt(time_now_obj.time_array[i]*Math.pow(10,(5-i)))
        }

        //判断秒是否发生了改变
        if (time_now_obj.time_array[5] != time_before_obj.time_array[5]) {

            //如果改变，根据秒的num来创建新的小球，注意传入参数true，代表把每个小球都push推进数组
            handle2.num(time_now_obj.time_array[5], {x: 7 * interval + begin_x, y: begin_y}, true)
        }
        if (time_now_obj.time_array[4] != time_before_obj.time_array[4]) {

            //创建新的小球
            handle2.num(time_now_obj.time_array[4], {x: 6 * interval + begin_x, y: begin_y}, true)
        }


        //小球运动最关键的一步，更新小球位置并重新绘制，让人看着觉得是动起来了
        for (var i = 0; i < addballs.length; i++) {
            handle2.update(addballs[i])
            handle2.draw_update(addballs[i])
        }

        //判断，如果时间发生改变，把now时间赋给before时间，即更新时间
        if(now_flag!=before_flag){

            time_before_obj.time_array.length=[]

            for(var i=0;i<time_now_obj.time_array.length;i++){
                time_before_obj.time_array[i]=time_now_obj.time_array.slice(i,i+1)
            }

            before_flag=now_flag
        }


        timer=setTimeout(animation,30)

    }

    animation()

}


