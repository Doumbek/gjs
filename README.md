1. Basic

    * Show all tasks

      `gradle tasks --all`
    * Show tasks for specific module

      `gradle mGradle:tasks`
    * Show dependencies for specific module

      `gradle mCucumber:dependencies`

2. Install to local Maven
    * Install all modules

      `gradle install`
    * Install specific module

      `gradle mGradle:install`

3. mGradle
    * Pack all files from zip to archive

      `gradle mGradle:packToZip`

    * Run as application

      `gradle mGradle:run`

4. mJunit5
    * Run all tests (defined in build.gradle)

      `gradle mJunit5:test`
    * Run by full name

      `gradle mJunit5:test --tests "com.gjs.mJunit5.CalculatorParamsTest"`
    * Run by part name

      `gradle mJunit5:test --tests "*ExtensionTest"`
    * Run specific tests

      `gradle mJunit5:test --tests "*Test.shouldUse*"`
    * Run include tags

      `gradle mJunit5:test -DincludeTags="divide|multiply"`
    * Run exclude tags

      `gradle mJunit5:test -DexcludeTags="exception|multiply"`
    * Run specific scope with tags

      `gradle mJunit5:test --tests "*CalculatorTest" -DincludeTags="divide" -DexcludeTags="exception"`

5. mCucumber
    * Run tests using Main via cli

      `gradle mCucumber:cucumber`
    * Run tests using Junit

      `gradle mCucumber:test`
    * Run by tag from cli

      `gradle mCucumber:cucumber -Dtags="@smoke and not @third"`

6. mSelenide
    * Run tests

      `gradle clean mSelenide:test`

    * Download Allure for CLI

      `./gradlew mSelenide:downlodAllure --info`

    * Generate reports

      `./gradlew mSelenide:allureServe`

7. mThread
    * Run OperationsExecutors class

      `./gradlew clean mThread:run -Dmain="main.OperationsExecutors"`

    * Run OperationsLock class

      `./gradlew clean mThread:run -Dmain="main.OperationsLock"`

    * Run OperationsExecutors class

      `./gradlew clean mThread:run -Dmain="main.OperationsSemaphore"`

8. mPatterns
   * Run main class

     `./gradlew clean mPatterns:run -Dmain="behavioral.observer.Example"`


