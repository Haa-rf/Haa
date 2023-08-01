FROM eclipse-temurin:17-jre
WORKDIR /app
COPY blog-main/target/blog.jar /app
EXPOSE 9527
ENTRYPOINT ["java","-jar","blog.jar"]