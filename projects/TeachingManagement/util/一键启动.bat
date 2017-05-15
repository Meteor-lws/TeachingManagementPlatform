@echo off

set project_path=D:\IdeaWorkSpace
set tomcat_path=D:\Tomcat\Tomcat-7.0.75
set webapp_path=%tomcat_path%\webapps

cd /d %project_path%
echo war包拷贝。。。
for /R %%s in (*.war) do (
xcopy /y %%s %webapp_path%
)
echo war包拷贝完成

echo war包重命名。。。
move %webapp_path%\teaching-management.war %webapp_path%\teaching.war
echo war包重命名完成

cd /d %tomcat_path%\bin
echo 启动Tomcat。。。
startup.bat
echo 启动Tomcat完成

pause
