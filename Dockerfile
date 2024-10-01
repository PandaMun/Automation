# 베이스 이미지 설정
FROM eclipse-temurin:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 컨테이너로 복사
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 컨테이너에서 노출할 포트 설정
EXPOSE 8082

# 애플리케이션 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]