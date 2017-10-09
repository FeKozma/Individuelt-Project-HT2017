REM kommentar
@echo off
echo running...
CALL gradlew build
cd "JavaAPI-distribution"
cd "build"
cd "distributions"

rmdir /S /Q "JavaAPI-distribution-*"
REM mkdir "JavaAPI-distribution-*"

D:\7-zip2\7z.exe x JavaAPI-distribution-*.zip -y

cd "JavaAPI-distribution-*"
cd bin

"%PROGRAMFILES%\Git\bin\sh.exe" JavaAPI-distribution server ../var/conf/server.yml


pause
