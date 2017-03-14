# 启动springBoot服务: java -Didc=sh -jar build/libs/demo-0.0.1-SNAPSHOT.jar --server.port=8899
# 优雅地停止SpringBoot服务: curl -X POST localhost:8899/shutdown

# 更多方式详见: http://jaskey.github.io/blog/2016/04/05/shutdown-spring-boot-application-gracefully/


#dependencies任务会显示一个依赖树，其中包含了项目所用的每一个库以及它们的版本：
#$ gradle dependencies

#安装部署
#下载:spring-boot-1.4.2
#alias设置:export PATH=/home/wangguoxing/spring-boot-1.4.2/bin:$PATH

#编译打包 gradle build