# Проект по автоматизации тестирования для агрегатора новостей Feedbin (API)

### Содержание
[Технологии и инструменты](#Технологии-и-инструменты)  
[Сборка в Jenkins](#Сборка-в-Jenkins)  
[Удаленный запуск из терминала](#Команда-для-удаленного-запуска-автотестов-из-терминала)  
[Интеграция с Allure Report](#Интеграция-с-Allure-Report)  
[Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)  
[Интеграция с Jira](#Интеграция-с-Jira)  
[Уведомление в Telegram](#Уведомление-в-Telegram)  


### Технологии и инструменты

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`. Запуск браузера осуществляется в `Selenoid`.
Сборщик проекта - `Gradle`. Для удаленного запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и
отправкой результатов в `Telegram` при помощи бота. Так же осуществлена интеграция с `Allure TestOps` и `Jira`.

<p>
<a href="https://www.java.com/">
  <img width="7%" title="Java" src="src/test/resources/icons/java-original.svg">
</a>
<a href="https://www.jetbrains.com/">
  <img width="7%" title="IntelliJ IDEA" src="src/test/resources/icons/Idea.svg">
</a>
<a href="https://gradle.org/">
  <img width="7%" title="Gradle" src="src/test/resources/icons/gradle-plain.svg">
</a>
<a href="https://junit.org/junit5/">
  <img width="7%" title="JUnit5" src="src/test/resources/icons/Junit5.svg">
</a>
<a href="https://github.com/">
  <img width="7%" title="GitHub" src="src/test/resources/icons/github-mark-white.svg">
</a>
<a href="https://selenide.org/">
  <img width="7%" title="Selenide" src="src/test/resources/icons/Selenide.svg">
</a>
<a href="https://aerokube.com/selenoid/latest/">
  <img width="7%" title="Selenoid" src="src/test/resources/icons/Selenoid.svg">
</a>
<a href="https://qameta.io/allure-report/">
  <img width="7%" title="Allure Report" src="src/test/resources/icons/Allure.svg">
</a>
<a href="https://www.jenkins.io/">
  <img width="7%" title="Jenkins" src="src/test/resources/icons/jenkins-original.svg">
</a>
<a href="https://telegram.org/">
  <img width="7%" title="Telegram" src="src/test/resources/icons/Telegram.svg">
</a>
<a href="https://qameta.io/">
  <img width="7%" title="Allure TestOps" src="src/test/resources/icons/Allure_TO.svg">
</a>
<a href="https://www.atlassian.com/software/jira">
  <img width="7%" title="Jira" src="src/test/resources/icons/Jira.svg">
</a>
</p>

### Сборка в Jenkins
Для запуска сборки необходимо перейти на страницу проекта [qa_guru_21_final_project_api](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/)
в `Jenkins`, далее в раздел `Собрать с параметрами`, выбрать необходимые параметры и нажать
кнопку `Собрать`.
#### Параметры сборки:
- **WBHOST** - URL Selenoid (по умолчанию selenoid.autotests.cloud)
- **TASK** - задачи (по умолчанию test)
- **BROWSER** - браузер (по умолчанию chrome)
- **BROWSER_VERSION** - версия браузера (по умолчанию 100.0)
- **BROWSER_SIZE** - размер окна браузера (по умолчанию 1920x1080)

<p>
<img width="100%" title="Jenkins" src="src/test/resources/screenshorts/006-jenkins.png">
<img width="100%" title="Jenkins" src="src/test/resources/screenshorts/007-jenkins.png">
</p>

### Интеграция с Allure Report
При удаленном запуске тестов в `Jenkins`, автоматически генерируется [Allure Report](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/6/allure/)

##### [Overview](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/6/allure/#)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/004-allureReport.png">

##### [Test details](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/6/allure/#behaviors)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/008-allureReport.png">

### Интеграция с Allure TestOps

В отчете [Allure TestOps](https://allure.autotests.cloud/project/3751/launches) можно:

- просматривать созданные тест-кейсы и чек-листы,
- запускать ручные и автоматические тестовые прогоны,
- заводить дефекты,
- собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3751/dashboards)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/009-testOps_dashboards.png">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3751/test-cases?treeId=0)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/010-testOps_testCase.png">

### Интеграция с Jira

Интеграция `Allure TestOps` с `Jira`, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-), открытой в `Jira`, какие тест-кейсы были написаны в
рамках задачи и результат их выполнения.

<img width="100%" title="Jira" src="src/test/resources/screenshorts/011-jira.png">

### Уведомление в Telegram

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный `Telegram канал`.

<img width="40%" title="Jira" src="src/test/resources/screenshorts/005-telegram.png">

