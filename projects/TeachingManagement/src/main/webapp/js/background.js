/**
 * 后台管理侧首页脚本
 *
 * Created by lws on 2017/3/31.
 */

$(function () {
    $('#back-nav').find('a').click(function () {
        var title = $(this).text();
        var content = $('#back-tabs');
        if (content.tabs('exists', title)) {
            content.tabs('select', title);
        } else {
            var url = null;
            switch (title) {
                case '教师管理':
                    url = '/system/teacher';
                    break;
                case '学生管理':
                    url = '/system/student';
                    break;
                case '班级管理':
                    url = '/system/class';
                    break;
                case '密码管理':
                    url = '/system/password';
                    break;
                case '评价项管理':
                    url = '/evaluation/item';
                    break;
                case '留言审核':
                    url = '/evaluation/message';
                    break;
                case '评价分析':
                    url = '/evaluation/analysis';
                    break;
                case '考试安排':
                    url = '/examination/examination';
                    break;
                case '试题管理':
                    url = '/examination/question';
                    break;
                case '评分分析':
                    url = '/examination/analysis';
                    break;
                case '考勤管理':
                    url = '/education/attendance';
                    break;
                case '周报管理':
                    url = '/education/weekly';
                    break;
                case '课表管理':
                    url = '/education/course';
                    break;
                case '课件管理':
                    url = '/education/resources';
                    break;
                default:
                    break;
            }
            content.tabs('add', {
                title: title,
                closable: true,
                content: '<iframe width="100%" height="100%" frameborder="0"  src=' + url + '></iframe>'
            });
        }
    });
});