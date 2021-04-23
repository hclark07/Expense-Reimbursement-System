# Expense-Reimbursement-System (ERS) - Java CDE Full Stack

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can login and view all reimursement requests and past history for all emplyees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement. 

## Technologies Used

* Java
* JavaScript
* HTML/CSS
* PostgreSQL
* Javalin
* JDBC

## Features

List of features ready and TODOs for future development
* As employees, user's can login into account and be able to submit a type of reimbursement ticket (such as LODGING, FOOD, TRAVEL, AND OTHERS) with specific amount and description of that tickets.
* Employees are also able to view the status of all tickets they have submitted. 
* Once a ticket is submitted the default status for the ticket will be pending, and a finance manager will be able to review that ticket and are authorized to approve and deny requests for expense reimbursement. 
* As finance manaager, user can login into account and be able to review all tickets from employees. Managers can either approve or dney requests through a dropdown selection and then submitting at the end.
* There is also a filter search bar functionality for Managers in the top right corner that allows them to filter request by pending status. 

To-do list:
* Encrypted password on database. 
* Implementing email confirmation for new users and reset password functionality to users who forget their login information.
* Employees being able to upload reimbursement reciept images when creating tickets. 
* Managers being able to download and view receipt images.  

## Getting Started
   
*First we need to git clone project
> git clone https://github.com/hclark07/Expense-Reimbursement-System.git

*Then we need to install IntelliJ
> https://www.jetbrains.com/idea/download/#section=windows


## Usage

* Open the project in IntelliJ, go to the driver folder, right click the main.class file and then hit run. 
> ![main](https://user-images.githubusercontent.com/69532931/115915446-316ff500-a428-11eb-94ec-562115941985.png)

*After you run the main class, it will give you the url where the project is running which for us is http://localhost:9227/

*Login page to our application
>![login](https://user-images.githubusercontent.com/69532931/115915848-ca9f0b80-a428-11eb-9a6a-3acc9227f323.png)



## Contributors

> Here list the people who have contributed to this project. (ignore this section, if its a solo project)

## License

This project uses the following license: [<license_name>](<link>).

