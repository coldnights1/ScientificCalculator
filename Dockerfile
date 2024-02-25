FROM openjdk:17
COPY ./target/demo-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java","-cp","demo-0.0.1-SNAPSHOT.jar","com.example.demo.CalculatorApplication"]
