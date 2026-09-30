# Usamos una imagen oficial de Maven con Java 21 para compilar el proyecto
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiamos todo el contenido de la carpeta de tu proyecto
COPY .. .

# Compilamos el proyecto usando maven directamente (asegúrate de mover el pom.xml a la raíz o ajustar la ruta)
RUN mvn clean package -DskipTests

# Creamos la imagen final ligera para correr la aplicación
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiamos el JAR generado desde la etapa de compilación
COPY --from=build /app/target/veterinaria-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto (Render lo sobrescribirá con su variable PORT)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
