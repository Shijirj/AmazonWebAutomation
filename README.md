# Shop At Amazon 

This project is a Java-based test automation framework using **Selenium, Cucumber, and JUnit** for automating tests on Amazon's website. It covers a simple test scenario to demonstrate how to use these tools in a test automation project.

## Running the Scenarios

To execute the automated scenarios, use the following command in your terminal:

```bash
mvn clean test

**Test Scenario**
The test scenario covers the following steps:

Go to Amazon.
Search for "Green water bottle."
Add the first hat appearing in the search results to the cart with a quantity of 2.
Open the cart and assert that the total price and quantity are correct.
Reduce the quantity from 2 to 1 in the cart for the item selected in step 3.
Assert that the total price and quantity have been correctly updated.
Setting up the Environment
To run this project, ensure that the following tools are installed on your system:

Java (version > 11)
Apache Maven (version > 3.0.0)
Chrome browser installed (the WebDriver manager will download the appropriate driver for your Chrome version)
Please note that this configuration has been tested on Windows. You can also modify the browser used in the Driver class if needed.

Enjoy using this test automation framework for your projects!
