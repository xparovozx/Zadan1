# Zadan1

# Задание:
Разработать программу на языке Java для обработки файла, в котором задаются зависимости сущностей друг от друга. Каждая сущность
представлена своим уникальным идентификатором в виде целого числа. Зависимости задаются строкой в текстовом файле, содержащем 
произвольное количество строк формата:\<id сущности\> \<id сущности от которой она зависит\>. Файл читать из STDIN. Для
прочитанных сведенй о связях между сущностями необходимо найти циклические зависимости и вывести их в STDOUT в виде id сущностей
через пробел.

## Пример файла:
1 2  
2 1  
3 4  
5 6  
6 5  

## Ожидаемый вывод в STDOUT:
1 2 1  
5 6 5  

## Инструкция по запуску Windows (Данный пример был запущен на Windows 7)
Для сборки была использована система сборки gradle 3.1. В файле build.gradle установлено sourceCompatibility = 1.7 . То есть предполагается использование как минимум Jdk 1.7.

Открыть terminal в Intellij IDEA (или открыть cmd).

Переходим в консоли в папку, куда хотим клонировать репозиторий с программой.

Набираем в консоли команду, чтобы клонировать репозиторий:

```
git clone https://github.com/xparovozx/Zadan1.git
```

Дальше, вводим следующую команду:

```
cd Zadan1
```

После этого вводим следующую команду:
P.S. При выполнении данной команды могут появиться сообщения о кодировке или warnings о версии Java. Игнорируем данное сообщение и ждём
окончания сборки.

```
gradle installDist
```

Потом переходим в каталог .\build\install\Zadan1 вызовом команды: 

```
cd .\build\install\Testing-Zad
```

Чтобы запустить программу, выполним в консоли следующую команду: 
P.S. В папке bin хранятся сгенерированные gradle бинарные файлы. В папке InputFiles находится пример входного файла с 
данными из задания. В исходниках есть папка src\main\resources, откуда копируются текстовые файлы во время сборки в 
InputFiles.

```
bin\Testing-Zad < InputFiles\STDIN.txt
```
После выполнения команды, приведенного выше, будет отображён ответ.
