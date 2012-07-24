cp ../../bin/gui-input-1.2.2.jar bundle/gui-input-1.2.2.jar
cp ../../bin/hello-1.2.2.jar bundle/hello-1.2.2.jar
cp ../../bin/console-output-1.2.2.jar bundle/console-output-1.2.2.jar
java -Dlog4j.configuration=file:conf/log4j.properties -jar bin/felix.jar
