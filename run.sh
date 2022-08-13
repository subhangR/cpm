./mvnw clean package -Dspring.profiles.active=ci -DskipTests
 java -XX:InitialRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0 -jar target/CPM-0.0.1-SNAPSHOT.jar