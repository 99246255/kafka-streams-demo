����kafka_2.12-1.0.0
windows���òο���https://www.cnblogs.com/flower1990/p/7466882.html

����configĿ¼�ҵ��ļ�server.properties����
�ҵ����༭log.dirs=D:\Kafka\kafka_2.12-0.11.0.0\kafka-logs
�ҵ����༭zookeeper.connect=localhost:2181


����Kafka��װĿ¼D:\Kafka\kafka_2.12-0.11.0.0������Shift+�Ҽ���ѡ�񡰴�����ڡ�ѡ��������У����룺
1. ����zookeeper   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. ����kafka,  .\bin\windows\kafka-server-start.bat .\config\server.properties

Kafka�ᰴ��Ĭ�ϣ���9092�˿������У�������zookeeper��Ĭ�϶˿ڣ�2181


����Ҳ����࣬bin\windowsĿ¼�е�kafka-run-class.bat   179��
%CLASSPATH%����˫����
 set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp "%CLASSPATH%" %KAFKA_OPTS% %*
��Դ�ο�:http://blog.csdn.net/u012931508/article/details/55211390