/**
 * 后台管理脚本
 *
 * Created by lws on 2017/3/27.
 */

$(function () {
    $('#main-evaluation').find('a').click(function () {
        var title = $(this).text();
        var mainContent = $('#main-content');
        if (mainContent.tabs('exists', title)) {
            mainContent.tabs('select', title);
        } else {
            var url = null;
            switch (title) {
                case '评价项管理':
                    url = 'page/evaluation.jsp';
                    break;
                case '留言审核':
                    url = 'page/message.jsp';
                    break;
                case '评价分析':
                    url = 'page/analysis.jsp';
                    break;
                default:
                    break;
            }
            mainContent.tabs('add', {
                title: title,
                closable: true,
                content: '<iframe width="100%" height="100%" frameborder="0"  src=' + url + '></iframe>'
            });
        }
    });
});
