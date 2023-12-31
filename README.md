# Проект автоматизации тестирования для агрегатора новостей Feedbin (API)

<a href="https://feedbin.com/">
    <img title="Feedbin" src="src/test/resources/icons/feedbin_logo.png" alt="Feedbin">
</a>

> Хорошее место для чтения в сети.  
> Следите за своими увлечениями с помощью RSS, рассылок по электронной почте, подкастов и YouTube.

## [Содержание](#Содержание)
[Технологии и инструменты](#Технологии-и-инструменты)  
[Реализованные проверки](#Реализованные-проверки)  
[Локальный запуск тестов из терминала](#Локальный-запуск-тестов-из-терминала)  
[Сборка в Jenkins](#Сборка-в-Jenkins)    
[Интеграция с Allure Report](#Интеграция-с-Allure-Report)  
[Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)  
[Интеграция с Jira](#Интеграция-с-Jira)  
[Уведомление в Telegram](#Уведомление-в-Telegram)  


### Технологии и инструменты

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`, `Rest-Assured`. Сборщик проекта - `Gradle`. Для удаленного запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и
отправкой результатов в `Telegram канал` при помощи бота. Так же осуществлена интеграция с `Allure TestOps` и `Jira`.

<p align="center">
    <a href="https://www.java.com/">
      <img width="7%" title="Java" src="src/test/resources/icons/java-original.svg" alt="java">
    </a>
    <a href="https://www.jetbrains.com/">
      <img width="7%" title="IntelliJ IDEA" src="src/test/resources/icons/Idea.svg" alt="IntelliJ IDEA">
    </a>
    <a href="https://gradle.org/">
      <img width="7%" title="Gradle" src="src/test/resources/icons/gradle-plain.svg" alt="Gradle">
    </a>
    <a href="https://junit.org/junit5/">
      <img width="7%" title="JUnit5" src="src/test/resources/icons/Junit5.svg" alt="JUnit5">
    </a>
    <a href="https://rest-assured.io/">
      <img width="7%" title="Rest Assured" src="src/test/resources/icons/rest-assured.png" alt="Rest Assured">
    </a>
    <a href="https://github.com/">
      <img width="7%" title="GitHub" src="src/test/resources/icons/github-mark-white.svg" alt="GitHub">
    </a>
    <a href="https://selenide.org/">
      <img width="7%" title="Selenide" src="src/test/resources/icons/Selenide.svg" alt="Selenide">
    </a>
    <a href="https://qameta.io/allure-report/">
      <img width="7%" title="Allure Report" src="src/test/resources/icons/Allure.svg" alt="Allure Report">
    </a>
    <a href="https://www.jenkins.io/">
      <img width="7%" title="Jenkins" src="src/test/resources/icons/jenkins-original.svg" alt="Jenkins">
    </a>
    <a href="https://telegram.org/">
      <img width="7%" title="Telegram" src="src/test/resources/icons/Telegram.svg" alt="Telegram">
    </a>
    <a href="https://qameta.io/">
      <img width="7%" title="Allure TestOps" src="src/test/resources/icons/Allure_TO.svg" alt="Allure TestOps">
    </a>
    <a href="https://www.atlassian.com/software/jira">
      <img width="7%" title="Jira" src="src/test/resources/icons/Jira.svg" alt="Jira">
    </a>
</p>

[Назад к содержанию](#Содержание)

### Реализованные проверки
- Успешная/неуспешная авторизация пользователя
- Создание новой записи
- Получение всех тегов
- Создание нового тега
- Удаление тега

[Назад к содержанию](#Содержание)

### Локальный запуск тестов из терминала
`gradle clean test`

[Назад к содержанию](#Содержание)

### Сборка в [Jenkins](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/)
Для запуска сборки необходимо перейти на страницу проекта [qa_guru_21_final_project_api](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/)
в `Jenkins`, далее в раздел `Build with Parameters`, выбрать необходимые параметры и нажать
кнопку `Build`.

<img title="Jenkins" src="src/test/resources/screenshorts/006-jenkins.png" alt="Jenkins">
<img title="Jenkins" src="src/test/resources/screenshorts/007-jenkins.png" alt="Jenkins">

[Назад к содержанию](#Содержание)

### Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/)
При удаленном запуске тестов в `Jenkins`, автоматически генерируется отчет `Allure Report`

##### [Overview](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/#)

<img title="Allure Report" src="src/test/resources/screenshorts/004-allureReport.png" alt="Allure Report. Overview">

##### [Test details](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_api/allure/#behaviors/5778946ce3195933e780791617eb6bb7/7cfd74cd081d7033/)

<img title="Allure Report" src="src/test/resources/screenshorts/008-allureReport.png" alt="Allure Report. Test details">

[Назад к содержанию](#Содержание)

### Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3751/test-cases/26872?treeId=0)

В отчете `Allure TestOps` можно:
- просматривать созданные тест-кейсы и чек-листы,
- запускать ручные и автоматические тестовые прогоны,
- заводить дефекты,
- собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3751/dashboards)

<img title="Allure TestOps" src="src/test/resources/screenshorts/009-testOps_dashboards.png" alt="Allure TestOps. Dashboards">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3751/test-cases?treeId=0)
Для ручных тестов используется подход ["Тест-кейсы как код"](https://www.youtube.com/watch?v=Prm2-c_5mYs&t=39m32s). В `IntelliJ IDEA` установлен плагин `Allure TestOps Support`,
который позволяет интегририровать `IntelliJ IDEA` и `Allure TestOps`.  
В `IntelliJ IDEA` прописываются шаги для ручных тест-кейсов, прогоняются тесты и через `allure-results` синхранизируются
с `Allure TestOps` через команду `Allure TestOps: Upload Results`. В результате в `Allure TestOps` появляются тест-кейсы
для ручных тестов, написанные в `IDE`.  
Преимуществом такого подхода становиться то, что такие тест-кейсы легко поддерживать с помощью средств `IDE`.

<img title="Allure TestOps" src="src/test/resources/screenshorts/010-testOps_testCase.png" alt="Allure TestOps. Test cases">

[Назад к содержанию](#Содержание)

### Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-930)

Интеграция `Allure TestOps` с `Jira`, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-930),
созданной в `Jira`, какие тест-кейсы были написаны в рамках задачи и результат их выполнения.

<img title="Jira" src="src/test/resources/screenshorts/011-jira.png" alt="Jira">

[Назад к содержанию](#Содержание)

### Уведомление в [Telegram](https://t.me/apitests)

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный `Telegram канал`.

<p align="center">
    <img title="Jira" src="src/test/resources/screenshorts/005-telegram.png" alt="Telegram">
</p>

[Назад к содержанию](#Содержание)