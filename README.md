# MultiModule

명령어 라인에서 아래 명령어 실행하면, 컴파일 에러 발생함
인텔리j에서 우선 컴파일하였음.
gradlew clean :module-api:buildNeeded --stacktrace --info --refresh-dependencies -x test

실드후 프로파일 세팅하여 커맨드에서 실행
D:\1fast_study\MultiModule\module-api\build\libs>java -jar -Dspring.profiles.active=local module-api-0.0.1-SNAPSHOT.jar
