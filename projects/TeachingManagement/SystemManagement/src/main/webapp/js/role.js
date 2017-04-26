/**
 * Created by 朱高 on 2017/4/25.
 */
$(function () {
    showTree("treeRole", "findPermission", true);
});
function showTree(id, url, flag) {
    $("#" + id).tree({
        url: url,
        required: flag,//是否必填
        lines: true,//是否显示虚线
        onlyLeafCheck: flag,//只能选取叶子结点
        //不为叶子节点不让选上
        onBeforeSelect: function (node) {
            //node.target代表的是选取的结点
            //node代表整个结点对象
            if (!$(this).tree('isLeaf', node.target)) {
                return !flag;
            }
        },
        onClick: function (node) {
            if (flag) {
                if (!$(this).tree('isLeaf', node.target)) {
                    //idObject.combo('showPanel');
                }
            }
        },
        onLoadSuccess: function (node, data) {
            var _this = this;
            if (data) {
                $(data).each(function () {
                    if (this.state === 'closed') {
                        $(_this).tree('expandAll');
                    }
                });
            }
        }
    })
}