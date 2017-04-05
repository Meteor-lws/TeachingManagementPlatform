/**
 * Created by 朱高 on 2017/3/17.
 */
$(function () {
    $('#tabs').tabs({
        fit: true,
        border: false,
    });
    $("#accordion").accordion({
        fit: true,
        border: false,
    });
    $(".skip").linkbutton({
        target: true,
        plain: true,
        onClick: function () {
            var _this = $(this);
            var tabs = $('#tabs');
            if (tabs.tabs('exists', _this.text())) {//判断title = node.text这个选项卡是否存在
                tabs.tabs('select', _this.text());//存在就选中这个title = node.text的选项卡
            } else {
                tabs.tabs('add', {
                    title: _this.text(),
                    closable: true,
                    content: '<iframe width="100%" height="100%" frameborder="0"  src=' + (_this.attr("href")) + ' style="width:100%;height:100%;"></iframe>',
                });
            }
        }
    });
    /*$("#nav").tree({
     url : "tree",//请求响应的参数中根结点为closed，子节点为open
     lines : true,
     onLoadSuccess : function (node, data) {
     //node.css("background", "red");
     console.log(node);
     if(data){
     $(data).each(function (index, value) {
     if(this.state == "closed"){
     $("#nav").tree("expandAll");
     }
     })
     }
     },
     onClick : function (node) {
     console.log(node.url);
     if(node.url){
     if($("#tabs").tabs("exists", node.text)){//判断title = node.text这个选项卡是否存在
     $("#tabs").tabs("select", node.text);//存在就选中这个title = node.text的选项卡
     }else{
     $("#tabs").tabs("add",{
     title : node.text,
     closable : true,
     content :  '<iframe width="100%" height="100%" frameborder="0"  src='+node.url+' style="width:100%;height:100%;"></iframe>',
     });
     }
     }
     }
     })*/
});