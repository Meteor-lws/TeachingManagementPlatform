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
                    url = '/education/teacher';
                    break;
                case '学生管理':
                    url = '/education/student';
                    break;
                case '班级管理':
                    url = '/education/class';
                    break;
                case '用户管理':
                    url = '/system/UserManagement';
                    break;
                case '角色管理':
                    url = '/system/role';
                    break;
                case '权限管理':
                    url = '/system/permission';
                    break;
                case '数据字典':
                    url = '/system/dictionary';
                    break;
                case '评价项管理':
                    url = '/evaluation/ItemManagement';
                    break;
                case '留 言 审 核':
                    url = '/evaluation/MessageReview';
                    break;
                case '评 价 分 析':
                    url = '/evaluation/EvaluationAnalysis';
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
