# 使用OpenJDK基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制JAR文件到镜像中（替换your-app-name.jar为实际名称）
COPY target/*.jar app.jar

# 暴露Spring Boot默认端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "app.jar"]