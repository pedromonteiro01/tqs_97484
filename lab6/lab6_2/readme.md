# Lab6 - Static Code analysis (with Sonar Qube)
### Pedro Monteiro 97484
<br>

### **Sonar Qube** Installation
```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```

Interface is available at http://127.0.0.1:9000/
![Interface](./prints/interface.png)

By default the credentials are:
- login: admin
- password: admin

As asked, the credentials were changed.

Later a token was created to be used in code analysis, being able to loggin into the Sonar Qube container.
![Create Token](./prints/token.png)

Run code and analyzing with **Sonar Qube**:
```
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=tqs_lab6_2 \
  -Dsonar.host.url=http://127.0.0.1:9000 \
  -Dsonar.login=ae065b0656e8c70b2666ea9c514a25b541d6a41b
```
![Project Code Analysis](./prints/project.png)

### Problems
| Issue | Problem Description | How to Solve |
| :--- | :--- | :--- |
| Bug | 301 | 283 | 111 |
| Vulnerability | 301 | 283 | 111 |
| Code smell (major) | 301 | 283 | 111 |
