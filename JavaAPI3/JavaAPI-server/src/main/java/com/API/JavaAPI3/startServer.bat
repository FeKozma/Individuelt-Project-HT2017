REM kommentar
@echo off
echo running...
START gradlew 
pause
cd "JavaAPI-distribution"
cd "build"
cd "distributions"
unzip JavaAPI-distribution-0.0.0-dirty.zip
cd "JavaAPI-distribution-0.0.0-dirty"
./bin/JavaAPI-distribution server var/conf/server.yml
pause