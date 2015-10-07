    var EventUtil={
        addHandler:function(obj,type,handler){
            if(obj.addEventListener){
                obj.addEventListener(type,handler,false)
            }
            else if(obj.attachEvent){
                obj.attachEvent("on"+type,handler)
            }
            else{
                obj["on"+type]=handler
            }
        },

        removeHandler:function(obj,type,handler){
            if(obj.removeEventListener){
                obj.removeEventListener(type,handler,false)
            }
            else if(obj.detachEvent){
                obj.detachEvent("on"+type,handler)
            }
            else{
                obj["on"+type]=null
            }
        }
    }