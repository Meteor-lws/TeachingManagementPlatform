$(function () {

// ����༶����
    $("#classBtn")
        .click(
            function () {
                var tab_name = $("#classBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="classEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });

//�����ʦ����
    $("#teacherBtn")
        .click(
            function () {
                var tab_name = $("#teacherBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="teacherEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//���ѧ������
    $("#studentBtn")
        .click(
            function () {
                var tab_name = $("#studentBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="studentEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//����������
    $("#passBtn")
        .click(
            function () {
                var tab_name = $("#passBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="passEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//����ܱ�����
    $("#weeklyBtn")
        .click(
            function () {
                var tab_name = $("#weeklyBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="weeklyEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//����α����
    $("#scheduleBtn")
        .click(
            function () {
                var tab_name = $("#scheduleBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="scheduleEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//����μ�����
    $("#coursewareBtn")
        .click(
            function () {
                var tab_name = $("#coursewareBtn").children(
                    "span:first").children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="coursewaresEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });
//������ڹ���
    $("#workBtn")
        .click(
            function () {
                var tab_name = $("#workBtn").children("span:first")
                    .children("span:first").html();
                if ($('#main_tab').tabs('exists', tab_name)) {
                    $("#main_tab").tabs('select', tab_name)
                } else {

                    $("#main_tab")
                        .tabs(
                            'add',
                            {
                                title: tab_name,
                                content: '<iframe width="100%" height="100%" frameborder="0"  src="workEdit.jsp" style="width:100%;height:100%;"></iframe>',
                                closable: true,
                                tools: [{}]

                            });
                }
            });

});

