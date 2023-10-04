# sample-graal
### https://start.spring.io
![image](https://i.imgur.com/URGg6JN.png)
_Add the `GraalVM Native Support` dependency in start.spring.io_  
Using [_Rancher Desktop_](https://rancherdesktop.io/)

## How to make build image
[Using Maven](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html#native-image.developing-your-first-application.buildpacks.maven)  

### Gradle

```shell
$ gradle bootBuildImage
```

or 

`Gradle` -> `Tasks` -> `build` -> `bootBuildImage`
![image](https://i.imgur.com/eV5Ey7d.png)


## With Graal

### Build time (6m 9s)
![image](https://i.imgur.com/n6hCkZj.png)

### Run BuildImage
```shell
docker run --rm -p 8080:8080 graal-example:0.0.1-SNAPSHOT
```

### Logs (process running for 0.191, A WE SOME!)
```text
2023-10-04T11:05:26.511Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-10-04T11:05:26.587Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2023-10-04T11:05:26.592Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-04T11:05:26.593Z  INFO 1 --- [           main] c.e.g.GraalExampleApplicationKt          : Started GraalExampleApplicationKt in 0.187 seconds (process running for 0.191)
2023-10-04T11:06:12.776Z  INFO 1 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2023-10-04T11:06:12.777Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-10-04T11:06:12.777Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

## Without Graal

### Build time (3m 49s)
![image](https://i.imgur.com/lxibgTj.png)

### Run BuildImage
```shell
docker run --rm -p 8080:8080 without-native-graal-example:0.0.1-SNAPSHOT
```

### Logs (process running for 3.218)
```text
2023-10-04T11:17:33.819Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-10-04T11:17:34.205Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint(s) beneath base path '/actuator'
2023-10-04T11:17:34.271Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-04T11:17:34.283Z  INFO 1 --- [           main] w.WithoutNativeGraalExampleApplicationKt : Started WithoutNativeGraalExampleApplicationKt in 2.875 seconds (process running for 3.218)
2023-10-04T11:56:36.615Z  INFO 1 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2023-10-04T11:56:36.624Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-10-04T11:56:36.629Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

## Source
https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html
