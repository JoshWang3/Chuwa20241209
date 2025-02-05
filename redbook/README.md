## 🐳 Docker 部署

### 快速启动
```bash
docker run -p 8080:8080 yourdockerhub/redbook:1.0.0
```

### 镜像地址
- Docker Hub: [https://hub.docker.com/repository/docker/nwan0012/redbook/general](https://hub.docker.com/repository/docker/nwan0012/redbook/general)

### 构建自定义镜像
```bash
docker build -t nwan0012/redbook:firstversion .
```