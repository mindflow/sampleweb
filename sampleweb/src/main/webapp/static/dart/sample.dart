library hi;

import "dart:html";
import "dart:async";

void main() {
  query("#id4").text = "Hi, Dart";
  query('#makeRequest').onClick.listen(makeRequest);
}

void makeRequest(Event e){
  e.preventDefault();
  HttpRequest request = new HttpRequest();
  request.open("GET", "/HelloContent?input=SomeOtherInput");
  request.onLoadEnd.listen((e) => requestComplete(request));
  request.send();
}

void requestComplete(HttpRequest request){
  if(request.status == 200){
    String text = request.responseText;
    query("#id5").innerHtml = text;
  }else{
    query("#id5").text = "Error";
  }
}