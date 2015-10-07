var timer=null
function animation() {
    clearTimeout(timer)

    var now = new Date()
    var time = [now.getHours(),now.getMinutes(),now.getSeconds()]
    var time_string=""
    var time_array=[]

    function conbineStr(obj){
        for(var i=0;i<obj.length;i++){
            if(obj[i].toString().length<2){
                time_string+="0"+obj[i].toString()
            }
            else{
                time_string+=obj[i].toString()
            }
        }
    }

    //调用函数把时间nuber拼合起来并装成字符串
    conbineStr(time)

    //之后，还要把字符串转成数组
    function changeToArray(str) {
        for(var i=0;i<str.length;i++){
            time_array.push(str.slice(i,i+1))
        }
    }
    changeToArray(time_string)
    alert(time_string)
    alert(time_array)
    timer=setTimeout(animation,300)
}

animation()