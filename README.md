# webdriver-demo-basic

### Command line arguments (with defaults)
```sh
$  mvn clean test -Dmaven.test.skip=false \
    -Dcapabilities.browserName=firefox \
    -Dcapabilities.version=30 \
    -Dcapabilities.platform=ANY \
    -DseleniumServerUri=http://localhost:4444/wd/hub \
    -Dbuild.number=1
```

### Suggested reading
