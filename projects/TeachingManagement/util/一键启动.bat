@echo off

set project_path=D:\IdeaWorkSpace
set tomcat_path=D:\Tomcat\Tomcat-7.0.75
set webapp_path=%tomcat_path%\webapps

cd /d %project_path%
echo war������������
for /R %%s in (*.war) do (
xcopy /y %%s %webapp_path%
)
echo war���������

echo war��������������
move %webapp_path%\teaching-management.war %webapp_path%\teaching.war
echo war�����������

cd /d %tomcat_path%\bin
echo ����Tomcat������
startup.bat
echo ����Tomcat���

pause
