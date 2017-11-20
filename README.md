# FRC 4159 Offseason

This is the the robot code for Redwarf, a veteran offseason robot that competed in Madtown Throwdown 2017.

### IntelliJ + Gradle Setup

1. Install [Intellij IDEA](https://www.jetbrains.com/idea/download/).
2. Clone this repo `git clone https://github.com/Team4159/FRC-2017-Offseason`
3. Setup your `JAVA_HOME` path. Go to your `~/.bashrc`, `~/.zshrc`, etc. or `/etc/profile` to make this available to all
users besides yourself. Add ``export JAVA_HOME=\`/usr/libexec/java_home\` `` to that file. This will be it for terminal
work, but since IntelliJ is a graphical interface, also run ``launchctl setenv JAVA_HOME `/usr/libexec/java_home` ``.
4. Open up IntelliJ. Import a new project. Navigate to the cloned directory and open `build.gradle`.
5. Run `./gradlew idea` to generate IDE files for IntelliJ.

**Optional IntelliJ settings:**

- Enable auto import
- Set tabs to equal four spaces
- Set gradle configurations to run gradle commands in IntelliJ

**Using gradlew:**

You can set gradle commands in IntelliJ. For example the run button would run `./gradlew deploy`.

Or you can simply run them in the command line.

- ```./gradlew build``` will build your Robot Code.
- ```./gradlew deploy``` will build and deploy your code.  
- ```./gradlew riolog``` will display the RoboRIO console output on your computer.
- ```./gradlew smartDashboard``` will launch Smart Dashboard.

Reference [here](https://github.com/Open-RIO/GradleRIO/blob/master/README.md#commands) for more info and up to date
commands.

### Special thanks ###

- GradleRIO - [https://github.com/Open-RIO/GradleRIO](https://github.com/Open-RIO/GradleRIO)