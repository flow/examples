@echo off
SET BINDIR=%~dp0
CD /D "%BINDIR%"
java -jar target\render-test-*.jar
pause