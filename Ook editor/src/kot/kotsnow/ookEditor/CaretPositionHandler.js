function debilizm(){

var node = document.querySelector("body");
node.focus();
var textNode = node.firstChild;
var caret = 10; 
var range = document.createRange();
range.setStart(textNode, caret);
range.setEnd(textNode, caret);
var sel = window.getSelection();
sel.removeAllRanges();
sel.addRange(range);

}