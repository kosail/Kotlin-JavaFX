# How to setup IntelliJ IDEA to run JavaFX applications with Kotlin
<hr>
Last update: Feb, 8. 2025

---
## Steps to run setup JavaFX on Intellij
This steps are not only for Kotlin, but also for Java. In general, we have to follow these 4 simple steps:
1. You first have to add the JavaFX SDK (which you can download from [the official website](https://openjfx.io/)) and place it somewhere you don't gonna delete it by accident.

2. Create a project in IntelliJ by copying this template (`Menu` -> `New` -> `Project From Version Control`).

3. Right click in this project name and `Open Module Settings` (*you can also click in the project name and press F4*). Then, go to `Global Libraries` -> `+` (the button to add a new entry) -> `Java`. Add all the files inside the lib folder that you got from the JavaFX SDK. `Apply`, save and close.

4. From JDK 11+ you have to right click back in the project name and `Open Module Settings` again. Go to `Global Libraries`, right click over the JavaFX entry you created, and click `Add to modules`. **You have to do this every time you create a new JavaFX project, whether is a Java or Kotlin based project.


Almost done! You are now able to run the `Main.kt` file which is a simple `AnchorPane` with a `Label`. The last step is just **remember that if you will be using JavaFX modules like media or web, you have to add them to `module-info.java` file**.

---


## Common questions

(At least questions that I made to myself while suffering to configure all this without knowing anything)

---
### Why do I need that `module-info.java` file?
The `module` keyword you find within this file, was introduced in Java 9 as part of the Java Module System (Jigsaw Project). It is used to define a module, which is a self-contained unit of code that:

* Explicitly declares dependencies on other modules (`requires`).
* Controls which packages are exposed to other modules (`exports`).
* Allows reflection-based frameworks (like JavaFX's FXML) to access private elements (`opens`).

Since JavaFX is no longer bundled with the JDK, it is structured as a set of modular JARs (`javafx.base`, `javafx.controls`, etc.). If you use JavaFX in a modular application, you must explicitly declare dependencies in `module-info.java`. Otherwise, you'll get errors like `javafx.* package not found`.

---
### Can `module-info.java` be Written in Kotlin?
No. The Java Module System is part of Java itself, and there is no Kotlin equivalent syntax. You must write `module-info.java` in Java.

However, your Kotlin code will still respect and follow the module system rules defined in module-info.java.

---
### Is it possible to just don't have a `module-info.java` file? Like in a Non-Modular JavaFX + Kotlin
TDLR: Yes, but is not recommended. For a modern JavaFX project in Kotlin (or Java), it's best to use the module system (module-info.java). While Kotlin itself doesn’t have a module keyword, it fully supports Java modules through Java interop.

If you want to avoid a modules file, you can run JavaFX in non-modular mode by adding required JARs manually to your build system (gradle.build.kts or pom.xml). This means:
* Running JavaFX with classpath instead of the module system.
* Adding the --add-opens flag manually when running JavaFX to handle reflection issues.


---

Feel free to reach out if you have any questions or would like to make this template cleaner. I'm always open to feedback!
