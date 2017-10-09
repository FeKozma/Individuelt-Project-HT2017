cd /d/individuelt proj/eclipse files 3/Individuelt-Project-HT2017/JavaAPI3
./gradlew distZip
cd JavaAPI-distribution/
cd build
cd distributions
unzip JavaAPI-distribution-0.0.0-dirty.zip
cd JavaAPI-distribution-0.0.0-dirty
./bin/JavaAPI-distribution server var/conf/server.yml