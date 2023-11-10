# Проект по автоматизации тестирования для агрегатора новостей Feedbin (API)

<p align="center">
    <a href="https://feedbin.com/">
      <img title="Java" src="src/test/resources/icons/feedbin_logo.png">
    </a>
</p>

> Хорошее место для чтения в сети.  
> Следите за своими увлечениями с помощью RSS, рассылок по электронной почте, подкастов и YouTube.

### Содержание
[Технологии и инструменты](#Технологии-и-инструменты)  
[Реализованные проверки](#Реализованные-проверки)  
[Локальный запуск тестов из терминала](#Локальный-запуск-тестов-из-терминала)  
[Сборка в Jenkins](#Сборка-в-Jenkins)  
[Удаленный запуск из терминала](#Команда-для-удаленного-запуска-автотестов-из-терминала)  
[Интеграция с Allure Report](#Интеграция-с-Allure-Report)  
[Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)  
[Интеграция с Jira](#Интеграция-с-Jira)  
[Уведомление в Telegram](#Уведомление-в-Telegram)  


### Технологии и инструменты

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`. Сборщик проекта - `Gradle`. Для удаленного запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и
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

### Реализованные проверки
- Успешная/неуспешная авторизация пользователя
- Создание новой записи
- Получение всех тегов
- Создание нового тега
- Удаление тега

### Локальный запуск тестов из терминала
`gradle clean test`

### Сборка в Jenkins
Для запуска сборки необходимо перейти на страницу проекта [qa_guru_21_final_project_api](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/)
в `Jenkins`, далее в раздел `Build with Parameters`, выбрать необходимые параметры и нажать
кнопку `Build`.

<p>
<img width="100%" title="Jenkins" src="src/test/resources/screenshorts/006-jenkins.png">
<img width="100%" title="Jenkins" src="src/test/resources/screenshorts/007-jenkins.png">
</p>

### Интеграция с Allure Report
При удаленном запуске тестов в `Jenkins`, автоматически генерируется [Allure Report](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/)

##### [Overview](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/#)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/004-allureReport.png">

##### [Test details](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/#behaviors/5778946ce3195933e780791617eb6bb7/7cfd74cd081d7033/)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/008-allureReport.png">

### Интеграция с Allure TestOps

В отчете [Allure TestOps](https://allure.autotests.cloud/project/3751/test-cases/26872?treeId=0) можно:

- просматривать созданные тест-кейсы и чек-листы,
- запускать ручные и автоматические тестовые прогоны,
- заводить дефекты,
- собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3751/dashboards)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/009-testOps_dashboards.png">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3751/test-cases?treeId=0)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/010-testOps_testCase.png">

### Интеграция с Jira

Интеграция `Allure TestOps` с `Jira`, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-930), открытой в `Jira`, какие тест-кейсы были написаны в
рамках задачи и результат их выполнения.

<img width="100%" title="Jira" src="src/test/resources/screenshorts/011-jira.png">

### Уведомление в Telegram

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный `Telegram канал`.

<img width="40%" title="Jira" src="src/test/resources/screenshorts/005-telegram.png">

