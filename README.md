# Final Project EPAM

## Overview

Automated UI tests for https://www.saucedemo.com/.

---

## Test Scenarios

### UC-1 Checkout Flow (one item)

- Login with standard_user
- Add a specific product to the cart (e.g. "Sauce Labs Backpack")
- Go to Cart and validate the item is present
- Proceed to Checkout
- Fill in Information form (First Name, Last Name, Zip)
- Complete checkout and validate success message:  
  "Thank you for your order!"

---

### UC-2 Checkout Flow (several items)

- Login with standard_user
- Add a specific product to the cart (e.g. "Sauce Labs Backpack")
- Add another product to the cart
- Go to Cart and validate both items are present
- Proceed to Checkout
- Fill in Information form (First Name, Last Name, Zip)
- Validate final price equals the sum of both product prices
- Complete checkout and validate success message:  
  "Thank you for your order!"

---

## Technical Requirements

Tool: Selenium WebDriver  
Browsers: Chrome, Firefox (Run in Parallel)  
Pattern: Page Object Model (POM)  
Locators: CSS Selectors, Xpath  
Reporting: Allure (or similar HTML report)  
Documentation: README.md with execution and report instructions

## Environment

- Base URL: https://www.saucedemo.com/
- User: standard_user
- Password: secret_sauce

---

## Run tests

Run using TestNG:  
Right click on testng.xml → Run

or via Maven:
mvn clean test

---

## Browsers

Tests run in parallel in Chrome and Firefox  
Configured in testng.xml

---

## Report

After execution report is generated in:
target/surefire-reports