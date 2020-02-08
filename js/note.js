/*
 * check num:is null and field check
 */
function checkNum(paraNum,minNum,maxNum) {
    var regNum = /^[0-9]*$/;
    if(checkNullPlus(paraNum,"数字")) {
        return false;
    }
    if(!regNum.test(paraNum)) {
        alert("请输入正确的整数");
        return false;
    }else if(paraNum < minNum || paraNum > maxNum) {
        alert("请输入" + minNum + "到" + maxNum + "间的数字");
        return false;
    }else{
        return true;
    }
}


function getFormElts(formName) {
    var formElts = formName.elements;
    var reStr = '';
    var objForm = new Object();
    for(var i=0;i<formElts.length;i++){
        //get element obj
        elt = formElts[i];
        if (elt.type == "password" || elt.type == "text") {
            objForm[elt.name] = elt.value;
            if(elt.style.display != "none") {
                reStr = reStr + "&" + elt.name + "=" + elt.value;
            }
        }
        if (elt.type == "checkbox"){
            reStr = reStr + "&" + elt.name + "=" + elt.checked;
        }
    }
    objForm["postInfo"] = reStr;
    return objForm;
}