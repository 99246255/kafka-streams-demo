下载kafka_2.12-1.0.0
windows配置参考：https://www.cnblogs.com/flower1990/p/7466882.html

进入config目录找到文件server.properties并打开
找到并编辑log.dirs=D:\Kafka\kafka_2.12-0.11.0.0\kafka-logs
找到并编辑zookeeper.connect=localhost:2181


进入Kafka安装目录D:\Kafka\kafka_2.12-0.11.0.0，按下Shift+右键，选择“打开命令窗口”选项，打开命令行，输入：
1. 启动zookeeper   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. 配置kafka,  .\bin\windows\kafka-server-start.bat .\config\server.properties

Kafka会按照默认，在9092端口上运行，并连接zookeeper的默认端口：2181


如果找不主类，bin\windows目录中的kafka-run-class.bat   179行
%CLASSPATH%加上双引号
 set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp "%CLASSPATH%" %KAFKA_OPTS% %*
来源参考:http://blog.csdn.net/u012931508/article/details/55211390