ST2 - Testen - README.md
==
# Vorgehen:
1. Versionskontrolle
    * [Git](https://github.com/LeonardHerbst/St2_LinkedList)
2. Element of Surprise
3. Dokumentationsdatei anlegen (readme), Arbeitsschritte dokumentieren, evtl. mit Screenshots
4. Maven-Projekt (JUnit5 -> AssertJ
    * Maven-Project angelegt
        * Folgende Dependencies in der pom.xml angelegt: AssertJ
    * ``` xml
        <dependencies>
            <dependency>
                AssertJ
            </dependency>
        </dependencies>
        ```
    * aktuellstes Surefire-Plugin hinzugefügt, damit die Tests laufen
5. Die Kompilierung sowie das Ausführen der Tests kann in Maven durch das Ausführen von Goals angestoßen werden.
6. Welche Codestellen habe ich abgedeckt - Jacoco (und EclEmma, integriert Jacoco in Eclipse)
    * Jacoco mithilfe Maven als Plugin einfügen mit:
    * ``` xml
        <build>
            <plugins>
                Jacoco-Plugin
            </plugins>
            …
        </build>
        ```
    * Jacoco konfigurieren:
        * durch entsprechende XML-Tags in der POM.xml (Project Object Model)
    * Jacoco deckt ab:
        * Instruktionen
        * Verzweigungen
7. TestSuite
    * SimpleLinkedList Test hinzugefügt (in Package st2e3):

| Nr. | Beschreibung                              | Testschritte                            | Erwartetest Ergebnis          | Status    |
| --- | ----------------------------------------- | --------------------------------------- | ----------------------------- | --------- |
| 1   | Element in Liste enthalten                | add(testString) contains(testString)    | contains("Hello Test!")       | ok        |
| 2   | Reihenfolge bleibt erhalten               | add(s1) add(s2) order                   | gleiche Reihenfolge           | ok        |
| 3   | Duplikate (und Size-Funktion funkioniert) | element zwei mal hinzufügen             | zwei mal drin                 | ok        |
| 4   | Null einfügen                             | Null in Liste geben                     | null wird aufgenommen         | ok        |
| 5   | Remove-Methode                            | schauen, ob richtige Exception kommt    | UnsupportedOperationException | Exception |
| 6   | leere Liste, iter hasNext()               | Fehler bei hasNext, wenn Liste leer ist | ok                            | ok        |

7. Fehler beheben, die wir finden
    1. Semikolon zu viel in Zeile 34 (aufgedeckt vom 1. Test)
    2. Falsche Befehlsreihenfolge in Zeile 61: Zugriff auf Elementcontent nachdem der Zeiger advanced wurde (aufgedeckt vom 1. Test)
   > Lösung: "content = current.elem, return content" hinzugefügt dependency site plugin fehlt
8. Compilerwarniungen konfigurieren (auf höchste Stufe)
    * -verbose eingeschaltet
9. Mit SpotBugs vertraut machen
    * wir fühlen uns sehr vertraut
    * Spotbugs als Plugin hinzugefügt (nach einigen Mühen)
    * Spotbugs-Check ausgeführt, Gui angeschaut (sehr hübsch)
        * Code angepasst:
        * ``` java
            public E next() {
            if (!this.hasNext()){
                throw new NoSuchElementException();
            }
            E content = current.elem;
            current = current.next;
            return content;
            }
            ```
10. Debugger: In-vitro Testing demonstrieren, Screenshot wie es aussieht im Debugger
    * siehe Screenshot:
    * ![](https://md.saab18.inf.tu-dresden.de/uploads/upload_6f5fddfca45eb84e0fb0e9bc57da8d28.png)
