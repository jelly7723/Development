window.onload= function () {
    var canvas = document.getElementById("canvas")
    canvas.width = "1500"
    canvas.height = "800"
    var context = canvas.getContext("2d")


    var ball={x:200,y:200,v_x:6,v_y:2,a:3,r:20}

    function draw_circle(obj) {
        context.clearRect(0,0,1500,800)
        context.beginPath()
        context.arc(obj.x,obj.y,obj.r,0,2*Math.PI,false)
        context.fillStyle="green"
        context.closePath()
        context.fill()
    }

    function  update(obj) {
            obj.x+=obj.v_x
            obj.v_y+=obj.a
            obj.y+=obj.v_y

            if(800-obj.y<=obj.r){
                obj.y=800-obj.r
                obj.v_x=obj.v_x*0.7
                obj.v_y=-obj.v_y*0.7
            }

    }

    var timer=null
    function circle_animation(){
        clearTimeout(timer)

        draw_circle(ball)
        update(ball)

        timer=setTimeout(circle_animation,30)
    }

    circle_animation()
}
