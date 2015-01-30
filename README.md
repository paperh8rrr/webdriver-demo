# webdriver-demo

```sh
$  mvn clean test -Dmaven.test.skip=false \
    -Dcapabilities.browserName=firefox \
    -Dcapabilities.version=30 \
    -Dcapabilities.platform=ANY \
    -DseleniumServerUri=http://localhost:4444/wd/hub \
    -Dbuild.number=1
```

### Suggested reading
- http://testng.org/doc/documentation-main.html
- https://docs.saucelabs.com/reference/test-configuration/
- https://github.com/saucelabs/saucerest-java
- http://w3c.github.io/webdriver/webdriver-spec.html
- http://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
