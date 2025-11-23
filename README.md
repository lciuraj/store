# Projekt prezentujący model MVC.

## Pobranie projektu z GitHub:

* Otwórz terminal (Command Prompt lub PowerShell na Windowsie, terminal na macOS lub Linuxie).

* Upewnij się, że masz zainstalowanego Git’a, wpisując polecenie:

`` git --version ``

Jeśli Git nie jest zainstalowany, pobierz i zainstaluj go z oficjalnej strony.

* W terminalu przejdź do katalogu, w którym chcesz umieścić projekt:

`` cd /sciezka/do/katalogu ``

* Skopiuj projekt z GitHub, wpisując polecenie:

`` git clone https://github.com/lciuraj/store.git ``


### Budowanie projektu za pomocą Mavena

* Upewnij się, że masz zainstalowanego Maven’a, wpisując polecenie:

`` mvn -v ``


Jeśli Maven nie jest zainstalowany, pobierz i zainstaluj go z oficjalnej strony.

* Aby zbudować projekt, w terminalu wpisz:

`` mvn clean install ``

> clean usuwa wszystkie pliki wygenerowane w poprzednich kompilacjach.

> install buduje projekt i instaluje jego artefakty w lokalnym repozytorium Maven. 


po zbudowaniu projektu, **przejdź do sekcji**: ["## Uruchamianie serwera aplikacyjnego Tomcat"](#uruchamianie-serwera-aplikacyjnego-tomcat)
 
## Jak sklonować i zbudować projekt przy użyciu IntelliJ IDEA (Community Edition)

1. **Uruchom IntelliJ IDEA**:
- Po uruchomieniu IntelliJ IDEA, wybierz opcję `Get from VCS` (lub `Clone from VCS` w zależności od wersji).

2. **Skonfiguruj repozytorium Git**:
- W polu `URL` wklej adres repozytorium: `https://github.com/lciuraj/store.git`.
- Wybierz lokalizację na swoim dysku, gdzie chcesz zapisać projekt.
- Kliknij `Clone`.

3. **Instalacja Git przez IntelliJ**:
- Jeśli Git nie jest zainstalowany, IntelliJ IDEA zaproponuje jego instalację. Wybierz `Download and Install Git` i postępuj zgodnie z instrukcjami.

4. **Instalacja Java SDK**:
- Jeśli Java SDK nie jest skonfigurowane, IntelliJ IDEA wyświetli komunikat o jego braku. W takim przypadku:
  - Kliknij `Setup SDK`.
  - Wybierz `Download JDK` i wybierz odpowiednią wersję (rekomendowane jest użycie wersji kompatybilnej z projektem, np. Java 17).
  - Postępuj zgodnie z instrukcjami, aby pobrać i zainstalować JDK.

5. **Zbuduj projekt za pomocą Maven**:
- W oknie `Maven` (domyślnie po prawej stronie ekranu), kliknij na ikonę rozwijania `store`.
- Znajdź sekcję `Lifecycle` i kliknij dwukrotnie `clean`, a następnie `install`.
- IntelliJ IDEA rozpocznie budowanie projektu, a wszystkie zależności zostaną pobrane i zainstalowane automatycznie.


## Uruchamianie serwera aplikacyjnego Tomcat

1. **Pobierz Apache Tomcat** z oficjalnej strony (użyj wersji 10).

2. **Rozpakuj pobrany plik ZIP** (lub TAR.GZ dla systemów Unix) do wybranego katalogu.

3. **Upewnij się, że JAVA_HOME jest ustawione** i wskazuje na Twoją instalację JDK, ponieważ Tomcat wymaga Javy. Możesz to zrobić w następujący sposób:
  - Na Windows:
    ```shell
    set JAVA_HOME=C:\ścieżka\do\jdk
    ```
  - Na macOS/Linux:
    ```shell
    export JAVA_HOME=/ścieżka/do/jdk
    ```

4. **Zbuduj projekt przy użyciu Maven**:
  - W IntelliJ IDEA otwórz okno `Maven` (domyślnie po prawej stronie ekranu) i w sekcji `Lifecycle` kliknij dwukrotnie `package`.
  - Maven wygeneruje plik `.war` w katalogu `target` o nazwie `store-1.0-SNAPSHOT.war` (lub podobnej, w zależności od ustawień projektu).

5. **Skopiuj wygenerowany plik `.war` do katalogu `webapps` w katalogu instalacyjnym Tomcat**:
  - Na Windows:
    ```shell
    copy target\store-1.0-SNAPSHOT.war C:\Tomcat\webapps\
    ```
  - Na macOS/Linux:
    ```shell
    cp target/store-1.0-SNAPSHOT.war /opt/tomcat/webapps/
    ```

6. **Uruchom Tomcat**:
  - Na Windows uruchom skrypt `startup.bat` znajdujący się w katalogu `bin` Tomcata:
    ```shell
    C:\Tomcat\bin\startup.bat
    ```
  - Na macOS/Linux uruchom skrypt `startup.sh` w katalogu `bin`:
    ```shell
    /opt/tomcat/bin/startup.sh
    ```

7. **Sprawdzenie aplikacji w przeglądarce**:
  - Domyślnie Tomcat działa na porcie `8080`. Jeśli jest on już zajęty przez inną usługę, możesz zmienić port w pliku `server.xml` znajdującym się w katalogu `conf` Tomcata:
    - Otwórz `server.xml` i znajdź linię:
      ```xml
      <Connector port="8080" protocol="HTTP/1.1"
      ```
    - Zmień `8080` na inny dostępny port, np. `8081`:
      ```xml
      <Connector port="8081" protocol="HTTP/1.1"
      ```
  - Następnie otwórz przeglądarkę i wpisz w pasku adresu:
    ```
    http://localhost:8080/store-1.0-SNAPSHOT/
    ```
    (jeśli port został zmieniony, użyj odpowiedniego numeru portu, np. `http://localhost:8081/store-1.0-SNAPSHOT/`).

8. **Zatrzymywanie Tomcat**:
  - Na Windows: uruchom skrypt `shutdown.bat`:
    ```shell
    C:\Tomcat\bin\shutdown.bat
    ```
  - Na macOS/Linux: uruchom skrypt `shutdown.sh`:
    ```shell
    /opt/tomcat/bin/shutdown.sh
    ```

### Ważne:
- **Po każdej modyfikacji kodu**:
    - Zbuduj projekt ponownie w IntelliJ IDEA za pomocą Maven (`package` w sekcji `Lifecycle`).
    - Skopiuj ponownie wygenerowany plik `.war` z katalogu `target` do katalogu `webapps` Tomcata:
        - Na Windows:
          ```shell
          copy target\store-1.0-SNAPSHOT.war C:\Tomcat\webapps\
          ```
        - Na macOS/Linux:
          ```shell
          cp target/store-1.0-SNAPSHOT.war /opt/tomcat/webapps/
          ```
    - Ponownie uruchom Tomcat, aby zobaczyć zmiany w aplikacji.

# ZADANIA DO SAMODZIELNEGO WYKONANIA

## Zadanie 1: Dodaj przycisk "Rozmyśliłem się"
1. **Cel:** Dodanie przycisku, który będzie działał analogicznie do przycisku "Powrót do strony głównej" na każdej stronie działu.
2. **Kroki:**
  - Do każdego pliku `*.jsp` dodaj nowy formularz (`<form>`), który będzie zawierał przycisk z akcją powrotu na stronę główną.

## Zadanie 2: Dodaj nowy produkt do koszyka
1. **Cel:** Dodanie nowego produktu, który będzie można dodać do koszyka w taki sam sposób, jak już istniejące produkty.
2. **Kroki:**
  - Utwórz odpowiedni servlet obsługujący dodawanie tego produktu.
  - Utwórz odpowiedni plik `*.jsp` z formularzem umożliwiającym dodanie nowego produktu do koszyka.

## Zadanie 3: Dodaj przycisk "Wyczyść koszyk"
1. **Cel:** Dodanie funkcjonalności wyczyszczenia koszyka.
2. **Kroki:**
  - Dodaj metodę `clearBasket` do klasy `BasketService`.
  - Utwórz klasę `ClearBasketServlet` z odpowiednią metodą `doPost`, która wywoła `clearBasket`.
  - Zmodyfikuj odpowiednio klasę `BasketServlet`, aby obsługiwała akcję wyczyszczenia koszyka.

## Zadanie 4: Modyfikacja funkcji dodawania produktów do koszyka
1. **Cel:** Dodanie możliwości wyboru ilości produktów podczas dodawania ich do koszyka.
2. **Kroki:**
  - Dodaj pole `quantity` do encji produktu.
  - Zmodyfikuj metodę `buyItem` w klasie `BasketService`, aby obsługiwała ilość dodawanych produktów.
  - Zmodyfikuj metodę `doPost` w servletcie `AddToBasketServlet`, aby obsługiwała pole `quantity`.
  - Dodaj dodatkowe pole `input` typu `number` w odpowiednich plikach `*.jsp`.

## Zadanie 5: Sumowanie ilości produktów w koszyku
1. **Cel:** Zmodyfikowanie funkcji dodawania produktów do koszyka tak, aby ilość produktów sumowała się zamiast dodawać kolejny rekord tego samego produktu.
2. **Kroki:**
  - Zmodyfikuj metodę `buyItem` w klasie `BasketService`, aby sumowała ilość produktów w koszyku zamiast dodawać nowy wpis.

## Zadanie 6: Dodaj funkcjonalność odejmowania produktów
1. **Cel:** Dodanie możliwości odejmowania produktów z koszyka.
2. **Kroki:**
  - Utwórz metodę `sellItem` w klasie `BasketService`.
  - Utwórz servlet `SellFromBasketServlet` z metodą `doPost`, która obsłuży odejmowanie produktów.
  - Dodaj do plików `*.jsp` nowy formularz (`<form>`), analogiczny do formularza dodawania produktów, ale realizujący funkcję odejmowania produktów z koszyka.
