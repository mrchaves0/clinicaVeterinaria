# Etapa de compilación usando Maven Wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiamos todo el contenido (ahora que Render tiene el Root Directory en 'veterinaria/')
COPY . .

# Damos permisos de ejecución al Maven Wrapper y compilamos
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Etapa final para correr la aplicación ligera
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiamos el JAR generado desde la etapa de compilación
COPY --from=build /app/target/veterinaria-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto (Render lo sobrescribirá con su variable PORT)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]