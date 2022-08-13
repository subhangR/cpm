./mvnw clean package -Dspring.profiles.active=ci -DskipTests
log_file_name=$(date +'%d-%m-%Y-%s')
java -XX:InitialRAMPercentage=75.0 -XX:MaxRAMPercentage=75.0 -jar target/CPM-0.0.1-SNAPSHOT.jar &> target/${log_file_name}.log &
echo "**********************************************************************************************************************"
echo "******************************************Application Started****************************************************"


echo "            To see logs use this command"
echo "                tail -f target/${log_file_name}.log"
