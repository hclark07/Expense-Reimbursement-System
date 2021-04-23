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


* After you run the main class, it will give you the url where the project is running which for us is http://localhost:9227/

* Index page to our application (aka the login page)
>![login](https://user-images.githubusercontent.com/69532931/115915848-ca9f0b80-a428-11eb-9a6a-3acc9227f323.png)

* You can register a new account
>![newuser](https://user-images.githubusercontent.com/69532931/115917641-6893d580-a42b-11eb-8dae-3ece9d1cc0fa.png)

* When you login in this is the initial employee board.
* It has no tickets with two buttons
> ![newemployeeboard](https://user-images.githubusercontent.com/69532931/115917946-bb6d8d00-a42b-11eb-83e9-eb014e087cfb.png)

* If you click on the create new reimbursement ticket button, we are able to submit a new ticket. 
> ![newreimbursement](https://user-images.githubusercontent.com/69532931/115918223-1f905100-a42c-11eb-897d-afe9bdc6d5ba.png)

* We are now able to see our new ticket in the employee board, and if you hit the view button under description column. An alert pops up and displays the description text. 
> ![employeeboard1](https://user-images.githubusercontent.com/69532931/115918538-7d249d80-a42c-11eb-8624-775527c269a1.png)

* Hitting the logout button we are able to logout of our employee account and login into an already prepared manager account. As you can see different from the employee board, managers have the option to change a tickets status only if it is pending. You can see that the ticket we just created a moment ago is showcased under as ticket #2 and we will attempt to change its status to approved.
> ![managerboard](https://user-images.githubusercontent.com/69532931/115919213-63378a80-a42d-11eb-9807-eef43a58ea09.png)

> ![approving](https://user-images.githubusercontent.com/69532931/115919556-d5a86a80-a42d-11eb-8855-c6dda6ca8f04.png)

* Ticket #4 is the ticket we just approved
> ![approved](https://user-images.githubusercontent.com/69532931/115919633-f40e6600-a42d-11eb-9777-e34ebe05e3fc.png)

* Managers also have filtering functionality
> ![filterapproved](https://user-images.githubusercontent.com/69532931/115919714-0ee0da80-a42e-11eb-8033-7ce0998c4006.png)
>![filterdeny](https://user-images.githubusercontent.com/69532931/115919722-11dbcb00-a42e-11eb-9891-59d935555d05.png)
>![filterpending](https://user-images.githubusercontent.com/69532931/115919727-13a58e80-a42e-11eb-8fd9-c9c80c70f022.png)

* Logging out and logging back into our previous account we can see the new updated status of our ticket.
> ![employeeboardupdate](https://user-images.githubusercontent.com/69532931/115919902-4ea7c200-a42e-11eb-90d7-c018e54e1204.png)


