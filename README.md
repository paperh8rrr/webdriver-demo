# webdriver-demo

## step-1
Test using RemoteWebDriver and Standalone Selenium Server


```sh
$ curl -OL http://selenium-release.storage.googleapis.com/2.44/selenium-server-standalone-2.44.0.jar

$ java -jar selenium-server-standalone-2.44.0.jar

$ mvn clean test -Dmaven.test.skip=false
```

https://code.google.com/p/selenium/wiki/DesiredCapabilities

http://www.seleniumhq.org/docs/03_webdriver.jsp#running-standalone-selenium-server-for-use-with-remotedrivers