var tipTodayCounter = 0;
var stoppedTimeout = false;
// timeoutRotation();

function loadFunction(){
	removeAsk();
}

function moveScroller() {
    var move = function() {
        var st = $(window).scrollTop();
        var ot = $("#scroller-anchor").offset().top;
        var s = $("#partnerColumn");
        if(st > ot) {
            s.css({
                position: "fixed",
                top: "0px"
            });
        } else {
            if(st <= ot) {
                s.css({
                    position: "static",
                    top: ""
                });
            }
        }
    };
    $(window).scroll(move);
    move();
}

function removeAsk(){
	if(document.getElementById("apn-null-toolbar") != null){
		document.getElementById("mainMenu").style.top = "-16px";
		(elem=document.getElementById("apn-null-toolbar")).parentNode.removeChild(elem);
		(elem=document.getElementById("apn-body-style")).parentNode.removeChild(elem);
	}
}

function timeoutRotation(){
	//if(!stoppedTimeout ){
	//	setTimeout ( timeoutRotation, 10000 );
	//	rotateForwardTipToday();
	//}
}

function stopTimeout(){
	//stoppedTimeout = true;
}

function rotateForwardTipToday(){
	//hideCurrent();
	//rotate(1);
	//showCurrent();
}

function rotateBackTipToday(){
	//hideCurrent();
	//rotate(-1);
	//showCurrent();
}

function rotate($direction){
	tipTodayCounter += $direction;
	var element = document.getElementById("tipToday" + tipTodayCounter);
	if(element == null){
		tipTodayCounter = 0;
	}
}

function hideCurrent(){
	//var elementId = "tipToday" + tipTodayCounter;
	//var element = document.getElementById(elementId);
	//element.style.display = 'none';
}

function showCurrent(){
	//var elementId = "tipToday" + tipTodayCounter;
	//var element = document.getElementById(elementId);
	//element.style.display = 'block';
}

function inverseVisible(filterName,arrowName){
	var element = document.getElementById(filterName);
	var arrowElement = document.getElementById(arrowName);
	if(element.style.display!='none'){
		arrowElement.innerHTML = "»";
		element.style.display='none';
		disableFormElements(element.getElementsByTagName('input'));
		disableFormElements(element.getElementsByTagName('select'));
	}else{
		arrowElement.innerHTML = "«";
		element.style.display='block';
		enableFormElements(element.getElementsByTagName('input'));
		enableFormElements(element.getElementsByTagName('select'));
	}
}

function disableFormElements(all){
	for(var i = 0; i < all.length; i++){
		all[i].disabled='disabled';
	}
}

function enableFormElements(all){
	for(var i = 0; i < all.length; i++){
		all[i].disabled='';
	}
}

function fbs_click(url) {
	window.open(url,'sharer','toolbar=0,status=0,width=626,height=436');
	return false;
}

function setCookie(c_name,value,exdays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name){
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++){
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name){
			return unescape(y);
		}
	}
	return null;
}

function removeClipping(clippingName){
	if(clippingName==null || clippingName==""){
		return;
	}
	var cookie = new Array();
	cookieString = getCookie("clippings");
	if(cookieString != null){
		cookie = arrayifyString(cookieString);
	}
	var newArray = new Array();
	for(var key in cookie){
		if(escape(key) != clippingName){
			newArray[key] = cookie[key];
		}
	}
	cookie = newArray;
	cookieString = stringifyArray(cookie);
	setCookie("clippings",cookieString,365);
	var element = document.getElementById("clipping_" + clippingName);
	element.parentNode.removeChild(element);
}

function addClipping(entrypoint){
	var name = prompt("Angi navn for utklipp", "");
	addClippingWithName(name,entrypoint);
}

function addClippingWithName(name,entrypoint){
	if(name==null || name==""){
		return;
	}
	var cookie = new Array();
	cookieString = getCookie("clippings");
	if(cookieString != null){
		cookie = arrayifyString(cookieString);
	}
	var url = "" + window.location;
	cookie[name] = replaceEntrypoint(url,entrypoint);
	setCookie("clippings",stringifyArray(cookie),365);
	alert("Utklipp med navn '" + name + "' er tilgjengelig på forsiden");
}

function replaceEntrypoint(url,entrypoint){
	url = url.replace(/__epid(.*?)/gi,"__epid="+entrypoint+"&");
	return url;
}

function stringifyArray(arrayObject){
	var stringObject = "";
	for(var key in arrayObject){
		escapeKey = escape(key);
		escapeValue = escape(arrayObject[key]);
		if(escapeKey == "" || escapeValue == "undefined"){
			continue;
		}
		stringObject = stringObject + escapeKey + ":" + escapeValue + ",";
	}
	return stringObject;
}

function arrayifyString(stringObject){
	var arrayObject = new Array();
	var pairsArray = stringObject.split(",");
	for(var pairKey in pairsArray){
		var pairString = pairsArray[pairKey];
		var pairArray = pairString.split(":");
		key = unescape(pairArray[0]);
		value = unescape(pairArray[1]);
		arrayObject[key] = value;
	}
	return arrayObject;
}