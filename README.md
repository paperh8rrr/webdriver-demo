# webdriver-demo

## step-2
Test using SauceLabs

```sh
$ {{path-to-sauceconnect}}/bin/sc \
    -u {{saucelabs-user}} \
    -k {{saucelabs-access-key}}
```
```sh
$ mvn clean test -Dmaven.test.skip=false \
  -Duser={{saucelabs-user}} \
  -Dkey={{saucelabs-access-key}}
```

### Suggested reading
- https://docs.saucelabs.com/reference/sauce-connect/
- https://saucelabs.com/platforms
