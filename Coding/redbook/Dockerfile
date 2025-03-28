# 第一阶段：使用 Maven 构建应用
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /build
# 复制 Maven 配置文件
COPY pom.xml .
# 复制源码
COPY src ./src
# 构建应用，跳过测试（如果需要测试，可去掉 -DskipTests）
RUN mvn clean package -DskipTests

# 第二阶段：构建运行时镜像
FROM openjdk:17-jdk-alpine
WORKDIR /app
# 从构建阶段复制生成的 jar 文件到当前镜像中，并命名为 app.jar
COPY --from=build /build/target/*.jar app.jar
# 暴露应用端口（和 application.properties 中的 server.port 保持一致）
EXPOSE 5000
# 设置启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]