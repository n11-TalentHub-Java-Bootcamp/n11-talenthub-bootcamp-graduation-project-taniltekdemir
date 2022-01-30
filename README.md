<div id="top"></div>

# Project Description
Loan Application System
- can receive a loan application from the user, 
- can calculate the application with various algorithms,
- can send result by pop up sms and email, 
- Java language and Spring boot Framework are used on the backend,
- Frontend side is developed with ReactJS library.
- I prepared a video to introduce the project. You can access it from this [link](https://www.youtube.com/watch?v=6VBDXmBEQAo).

## Built With
- Java
- IntelliJ Idea or Eclipse
- Sprind Data JPA
- Lombok
- Mapstruct
- PostgreSql
- React JS
- NodeJs

## Installation
1. Clone the repo [repo](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir)
2. Import the project to your IDE
3. In PostgreSql, you need to add a database with the name credit_system
4. You can send requests using the clientside project and see the endpoints in the Swagger document [Api-docs.json](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/src/server/main/resources/Api-docs.json)
5. The project is running on the 8080 port by default. You can access the project run on the client side from http://localhost:3000/


## Some Highlights

###Login Process
JWT Token is used in the project. You can login to the project by getting a token. There are pages and methods that you can use without getting tokens. I will add some infos for Public and other Pages.
Endpoints you can use without getting tokens.

| Method    | URI                                    | Description          |
| ----------| -------------------------------------- | -------------------- |
| POST      | /auth/register                         | Register a user      | 
| POST      | /auth/login                            | Login process        | 
| POST      | /managers/interrogate                  | Apply result inquiry | 
| POST      | /managers/applyCreditWithoutRegistered | Credit apply         | 


### Strategy Design Pattern
The purpose of using this design pattern is to avoid code duplication and to make the code open to developing new features. You can add new conditions during the credit evaluation stage. You can give different results under current conditions. So you can use different strategies in runtime.I used 2 layers while determining the strategies. The first layer creates 3 different strategies according to your credit score.
For those with a credit score between 500-1000, there are 3 different substrategy in the second layer. You can use the same entity named Evaluator in these 5 different scenarios without needing to know which strategy to apply.
+ Strateg1
+ Strategy2
    + SubStrategy1
    + SubStrategy2
    + SubStrategy3
+ Strategy3

### Information with SMS and Email
You can see the loan application results instantly as a pop up. Also sms and email are sent.
I used VatanSMS API to send SMS. You can find the api configuration under inform module. Finally, I opened a fixed-term test account from the sms provider and I only have 9 sms balance.
spring boot java mail service was used to send mail. Emails are sent from a gmail account opened for this project. You can check application.properties for configurations. In the 4 tables created, there is no data that repeats each other.

### Modular programming and DB Desing
The software was designed by dividing the components of the program into manageable parts. Each module created can be developed and tested separately.
Entity relationship was used in db design to avoid duplicate data in tables. With the @Transactional annotation, incorrect records are prevented from being added in case of error.

### Validation
Validation of data types and control of mandatory fields were performed on both frontend and backend. Added restrictions to entities with Hibernate. Checked with @Valid in Controller layer.

### Logging
Lombok Slf4j was used for logging processors. Every important operation such as saving, updating, deleting, sending notification was logged.

### Documentation
Swagger was used for documentation. All endpoints are accessible. You can also be autorized in swagger by getting tokens after the login process. here is the link to the documentation file. [link]

### Exception Handling
Exception handling operations are customized. Created ExceptionResponse so that errors are in standard format. You can find these operations in "common/exception/" 
 
### Unit Test
Unit tests were written for operations performed at the service layer.


## Client Project Introduction
Two user types, Admin and Customer, are defined. There are pages that only Admin users can access.

## Public Pages
- **Registered Page** ![alt text](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/saveUser.png) : The necessary information is obtained to register as a customer in the system. Validation for phone, ID number, date of birth is also done on the front side. A request is sent to the `auth/register` endpoint.
- **Credit Apply Page without registered** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/applyCredit1.png) : You can apply for a loan directly to the system, the result will pop up on the screen. [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/applycredit2.png) Also, an sms will be sent to the phone number you provided at the application stage. If you have given an e-mail address, you will also be notified by e-mail. A new user will be created according to the entered information. You can login to the system with the tckn information you specified as username and password. If you apply with an existing ID number in the system, the loan application will not be accepted and a warning will be given. You can login with your registered user information and apply.
- **Interrogate Page** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/interrogatePage.png) : You can learn your result with the ID number you applied for and your birth information. If these two information do not match, an error message will be returned.
- **Login Page** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/loginPage.png) : You can login to the system with the ID number and password information you used while registering to the system or applying for a loan.

## Admin-only pages
- **CustomerList Page** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/customerListPage.png) : All customers are shown on this page as a table. You can delete a customer record. If the customer has a loan application, this record cannot be deleted.
- **CreditList Page**: [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/creditListPage.png) : Data in User, Credit Apply and Credit Evaluation tables are joined and displayed on this page.

## Pages that can be used as login
- **Credit Apply Page** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/creditApplywithLogin.png) : After logging in, you can apply for a loan by simply entering the salary and guarantee information.
- **User Profile Page** [image](https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-taniltekdemir/blob/main/image/userProfilePage.png) : The user can see the information registered in the system. Information other than ID number can be changed.

## alertify 
- Error messages are shown as pop ups with alertify.
- 

<p align="right">(<a href="#top">back to top</a>)</p>
