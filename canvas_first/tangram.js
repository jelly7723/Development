window.onload= function () {
    var tangram=[
        {position:[{x:0,y:0},{x:200,y:200},{x:0,y:400}],
         color:"red"},

        {position:[{x:0,y:0},{x:200,y:200},{x:400,y:0}],
         color:"green"},

        {position:[{x:0,y:400},{x:100,y:300},{x:200,y:400}],
         color:"orange"},

        {position:[{x:100,y:300},{x:200,y:200},{x:300,y:300},{x:200,y:400}],
         color:"blue"},

        {position:[{x:200,y:200},{x:300,y:100},{x:300,y:300}],
         color:"pink"},

        {position:[{x:300,y:100},{x:400,y:0},{x:400,y:200},{x:300,y:300}],
         color:"purple"},

        {position:[{x:200,y:400},{x:400,y:200},{x:400,y:400}],
         color:"yellow"},
    ]

    var canvas=document.getElementById("canvas")
    canvas.width="400"
    canvas.height="400"
    var context=canvas.getContext("2d")

    for(var i=0;i<tangram.length;i++)
    {
        context.beginPath()
        context.moveTo(tangram[i].position[0].x,tangram[i].position[0].y)

        for(var j=0;j<tangram[i].position.length;j++){
            context.lineTo(tangram[i].position[j].x,tangram[i].position[j].y)
        }
        context.closePath()

        context.fillStyle=tangram[i].color
        context.fill()
    }

}