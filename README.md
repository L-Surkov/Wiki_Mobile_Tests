
# Проект по автоматизации тестирования мобильного приложения [Wikipedia](https://play.google.com/store/apps/details?id=org.wikipedia&hl=ru)

> Wikipedia App — энциклопедический сервис, разработанный фондом Викимедиа, является официальным приложением интернет-энциклопедии Википедия для мобильных интернет-устройств.
> 
## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://ru.wikipedia.org/"><img src="images/logo/Wikipedia_logo.svg" width="50" height="50"  alt="Wikipedia"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Список автоматизированных тест-кейсов">**Список автоматизированных тест-кейсов:**</a>
____
- ✓ *Проверка онбординга при первом запуске приложения*
- ✓ *Проверка строки поиска*
- ✓ *Проверка отображения ошибки при некорректном поисковом запросе*
- ✓ *Проверка возможности переключения языка в настройках приложения*
- ✓ *Проверка отображения ошибки при авторизации с невалидными данными*

## <a name="Список ручных тест-кейсов">**Список ручных тест-кейсов:**</a>

- ✓ *Проверка добавления и сохранения статей либо новостей в избранном*
- ✓ *Проверка изменения оформления текста через настройку Theme*
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsWiki_Mobile_Tests/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsWiki_Mobile_Tests/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *ENVIRONMENT (тестовая среда, по умолчанию Test)*
- *PROP (конфигурация для запуска удалённо/на эмуляторе)*
- *BROWSERSTACK_USER (User_id из аккаунта BrowserStack)*
- *BROWSERSTACK_KEY (токен из аккаунта BrowserStack)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean mobile_main_tests 
-Dprop=${PROP}
-Dbrowserstack.user=${BROWSERSTACK_USER}
-Dbrowserstack.key=${BROWSERSTACK_KEY}
*Может быть использовано задание mobile_getting_started_tests для запуска тестов на экран онбординга
```

***Удалённый запуск через Jenkins:***
```bash  
clean mobile_main_tests
-Dprop=${PROP}
-Dbrowserstack.user=${BROWSERSTACK_USER}
-Dbrowserstack.key=${BROWSERSTACK_KEY}
*Может быть использовано задание mobile_getting_started_tests для запуска тестов на экран онбординга
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/038-L_Surkov-JenkinsWiki_Mobile_Tests/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/jenkins.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/jenkins_tests.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_graths.png" width="850">
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/telegram.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Пример видео выполнения одного из тестов на BrowserStack
____
<p align="center">
<img title="Selenoid Video" src="images/video/wiki_video.gif" width="150" height="450"  alt="video">   
</p>

