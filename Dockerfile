#образ maven для сборки проекта
FROM maven:3.2 as build
#собираем проект в рабочую директорию
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package

#образ jdk21 для запуска собранного jar файла
FROM openjdk:21
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]