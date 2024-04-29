# **Selenium Java TestNG Allure Reports Project**

Overview
This project is a test automation suite built using Selenium WebDriver with Java, TestNG for testing and Extent Reports for reporting. The suite is designed to automate tests for a web application and provide detailed reports on the results.

## **Features**

* Automated testing of web applications using Selenium WebDriver.
* Test case management and execution using TestNG.
* Reporting using ExtentReports for detailed test execution reports.

## **Prerequisites**

1. Java: Make sure Java JDK is installed and properly configured. You can check your Java version by running java -version in the command prompt or terminal.
2. Maven: Maven is used to manage dependencies and build the project. Make sure Maven is installed and configured properly.
3. WebDriver: The project uses Selenium WebDriver. You may need the drivers for specific browsers (e.g., Chrome, Firefox) installed and available in your PATH.


## **Setup**

Clone the Repository: Clone this repository to your local machine using the following command:

1. `Clone the repository to your local machine:` git clone [https://github.com/chandraSekhar-alti/SeleniumJavaTestNGExtent.git](https://github.com/chandraSekhar-alti/SeleniumJavaTestNGExtent.git)
2. `Navigate to the project directory:`   cd SeleniumJavaTestNGExtentReports
3. `Install the dependencies using Maven:` mvn clean install


**Install Dependencies**

Open a terminal or command prompt in the project directory and run the following command to install project dependencies using Maven:
* mvn clean install

**Run Tests**

Execute the test suite using Maven:
`mvn test`

## **Reporting**

The project uses Allure Reports for test reporting. After running the tests, you can generate the Allure reports using the following command:

1. `allure generate --clean`
2. `allure serve`


### **Project Structure**

**src/test/java:** This is the root directory for the project's test code.

* **pages**: This package contains page object classes that represent the different web pages under test, such as:
  * **HomePage.java**: Represents the home page of the application.
  * **ProfilePage.java**: Represents the profile page of the application.
  

* **Tests**: This package contains test classes for the application pages. Examples include:
  * **HomePageTests.java**: Contains tests for the home page.
  * **ProfilePageTests.java**: Contains tests for the profile page.
  * **BaseTest.java**: A base class for all test classes, providing common setup and utility methods.
  

* **Utils**: This package contains utility classes that provide common functionality to the tests. Examples include:
  * UI.java: Contains methods for interacting with UI elements.
  * AlertHandler.java: Provides methods for handling browser alerts.
  * BrowserAction.java: Contains methods for browser-specific actions.
  * WindowFrameHandling.java: Provides methods for handling browser window and frame operations.
  

* **Reports**: This package contains classes for generating and managing test reports using Allure. Examples include:
  * AllureTestListeners.java: Contains Allure reporting event listeners.
  * AllureTestListener.java: Handles Allure test events.
  

* **pom.xml**: Maven project configuration file.

**resources**: This directory contains resources used by the test suite, including:
* **config.json**: A JSON configuration file that contains different settings for various environments, such as regression, dev, and SMOKE. Each environment section includes properties like baseUrl, username, and password.
* **config.properties**: A properties file that can contain additional configuration settings for the tests.
* **image file**: Any image files required for testing purposes.


# Contributing

**Contributions to this project are welcome! If you would like to contribute, please follow these steps:**

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request.


**License**

This project is licensed under the [**MIT License**](https://opensource.org/license/mit) - see the LICENSE file for details.
