# Java 17을 위한 적절한 베이스 이미지 선택
FROM eclipse-temurin:17-jdk AS builder

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 파일들을 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Gradle 실행 권한 부여 및 빌드
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

# 실제 실행 환경 설정
FROM eclipse-temurin:17-jdk

# 빌드된 JAR 파일을 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 컨테이너에서 노출할 포트 설정
EXPOSE 8082

# 애플리케이션 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app.jar"]