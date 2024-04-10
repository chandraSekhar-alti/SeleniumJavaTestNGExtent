SeleniumJavaTestNGExtent
Overview
SeleniumJavaTestNGExtent is a Java-based automation testing project that utilizes Selenium WebDriver, TestNG, and ExtentReports for automated testing of web applications.

Features
Automated testing of web applications using Selenium WebDriver.
Test case management and execution using TestNG.
Reporting using ExtentReports for detailed test execution reports.
Setup
Clone the Repository: Clone this repository to your local machine using the following command:

bash
git clone https://github.com/chandraSekhar-alti/SeleniumJavaTestNGExtent.git
Prerequisites:

Java Development Kit (JDK) installed on your machine.
Maven installed on your machine.
ChromeDriver (or appropriate WebDriver for your browser) downloaded and added to the system PATH.
Import Project: Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

Install Dependencies: Open a terminal or command prompt in the project directory and run the following command to install project dependencies using Maven:

bash
mvn clean install
Run Tests: Execute the test suite using Maven:

bash
mvn test
View Reports: After running the tests, view the ExtentReports HTML report generated in the test-output directory.

Project Structure
src/test/java/: Contains test classes and utility classes.
src/test/resources/: Contains resources such as test data and configuration files.
pom.xml: Maven project configuration file.
Contributing
Contributions to this project are welcome! Feel free to open issues for bug reports, feature requests, or submit pull requests with enhancements or fixes.

License
This project is licensed under the MIT License - see the LICENSE file for details.
