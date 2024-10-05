# Backend_Traini8_VenkatBiyyapu


This project is a **Backend_Traini8_VenkatBiyyapu** built using Spring Boot. It allows users to add and retrieve information about training centers, including details like center name, address, capacity, courses offered, and contact information.

The backend exposes RESTful APIs for creating new training centers, searching for centers by various parameters like ```centerCode, CenterName, pinCode, coursesOffered, state, city and capicity``` feilds and retrieving all the training centers.

## Table of Contents
1. [Installation](#installation)
2. [API Endpoints](#api-endpoints)
    - [Base URL](#base-url)
    - [Create a Training Center (POST)](#create-a-training-center-post)
    - [Get All Training Centers (GET)](#get-all-training-centers-get)
    - [Get Training Centers by Pin Code (GET)](#get-training-centers-by-pin-code-get)
    - [Get Training Centers by Center Code (GET)](#get-training-centers-by-center-code-get)
    - [Get Training Centers by Capacity (GET)](#get-training-centers-by-capacity-get)
    - [Get Training Centers by Center Name (GET)](#get-training-centers-by-center-name-get)
    - [Get Training Centers by City or State (GET)](#get-training-centers-by-city-or-state-get)
    - [Get Training Centers by Courses Offered (GET)](#get-training-centers-by-courses-offered-get)
3. [Error Handling](#error-handling)
4. [Important Notes](#important-notes)


## Installation

### Prerequisites
- Java 11 installed on your system. 
- Maven installed for building the project.

### Steps to Install and Run the Project
1. **Install Java 11**: If you don’t have Java 11, download and install it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   
2. **Clone the repository**:
   ```bash
   git clone https://github.com/venkatbiyyapu/Backend_Traini8_VenkatBiyyapu.git
   ```
   
3. **Navigate to the project directory**:
   ```bash
   cd Backend_Traini8_VenkatBiyyapu
   ```

4. **Build the project using Maven**:
   ```bash
   mvn clean install
   ```

5. **Run the Spring Boot application**:
   ```bash
   java -jar target/Backend_Traini8_VenkatBiyyapu-0.0.1-SNAPSHOT.jar
   ```

6. **Access the API**: Once the application is running, the backend will be accessible at:
   ```
   http://localhost:8080
   ```

## API Endpoints

### Base URL
All API requests are prefixed with the following base URL:
```
http://localhost:8080/api/v1/training-centers
```

### Create a Training Center (POST)
- **Endpoint**: `/api/v1/training-centers`
- **Method**: `POST`
- **Description**: Creates a new training center.
- **Request Body** (Example):
  ```json
  {
    "centerName": "TechTrain4",
    "centerCode": "ABC1234XY235",
    "address": {
      "detailedAddress": "Gurramm St, Suite 4B",
      "city": "Ongole",
      "state": "AP",
      "pinCode": "523002"
    },
    "capacity": 10,
    "coursesOffered": ["Python", "React"],
    "contactEmail": "test2@gmail.com",
    "contactPhone": "1238567359"
  }
  ```
- **Response**:
  - Status Code: `201 Created`
  - Body:
    ```json
    {
      "id": 1,
      "centerName": "TechTrain4",
      "centerCode": "ABC1234XY235",
      "address": {
        "detailedAddress": "Meera St, Suite 4B",
        "city": "Ongole",
        "state": "KA",
        "pinCode": "523002"
      },
      "capacity": 10,
      "coursesOffered": ["Python", "React"],
      "contactEmail": "test2@gmail.com",
      "contactPhone": "1238567359",
      "createdOn": "2024-10-05T12:34:56Z"
    }
    ```

### Get All Training Centers (GET)
- **Endpoint**: `/api/v1/training-centers`
- **Method**: `GET`
- **Description**: Retrieves a list of all available training centers.
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers ```
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.
    
    

### Get Training Centers by Pin Code (GET)
- **Endpoint**: `/api/v1/training-centers/by-pincode`
- **Method**: `GET`
- **Description**: Retrieves training centers by their pin code.
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?pinCode=523001 ```
- **Parameters**:
  - `pinCode`: The pin code to search for.
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

### Get Training Centers by Center Code (GET)
- **Endpoint**: `/api/v1/training-centers/by-centercode`
- **Method**: `GET`
- **Description**: Retrieves training centers by their center code.
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?centerCode=ABC1234XY235 ```
- **Parameters**:
  - `centerCode`: The center code to search for.
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

### Get Training Centers by Capacity (GET)
- **Endpoint**: `/api/v1/training-centers/by-capacity`
- **Method**: `GET`
- **Description**: Retrieves training centers with a capacity greater than or equal to the specified value.
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?capacity=30 ```
- **Parameters**:
  - `capacity`: The minimum capacity value.
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

### Get Training Centers by Center Name (GET)
- **Endpoint**: `/api/v1/training-centers/by-centername`
- **Method**: `GET`
- **Description**: Retrieves training centers by center name (case-insensitive).
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?centerName=TechTrain4 ```
- **Parameters**:
  - `centerName`: The center name to search for.
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

### Get Training Centers by City or State (GET)
- **Endpoint**: `/api/v1/training-centers/by-cityorstate`
- **Method**: `GET`
- **Description**: Retrieves training centers by city or state (case-insensitive).
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?city=Ongole&state=AP ```
- **Parameters**:
  - `city`: The city to search for (optional).
  - `state`: The state to search for (optional).
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

### Get Training Centers by Courses Offered (GET)
- **Endpoint**: `/api/v1/training-centers/by-courses`
- **Method**: `GET`
- **Description**: Retrieves training centers based on the courses they offer.
- **Sample**: ``` curl -X POST http://localhost:8080/api/v1/training-centers?courses=Python&courses=Java&courses=SpringBoot ```
- **Parameters**:
  - `courses`: A list of courses to search for.
- **Response**:
  - Status Code: `200 OK`
  - Body: A list of `TrainingCenter` objects or an empty list if no data is found.

## Error Handling

Validation errors are returned with `400 Bad Request` status code. Here are some common validation errors:

- **centerName**: If the `centerName` exceeds 40 characters, the error returned is:
  ```json
  { "centerName": "Center Name must be less than 40 characters" }
  ```

- **centerCode**: If the `centerCode` is not exactly 12 alphanumeric characters:
  ```json
  { "centerCode": "Center Code must be exactly 12 alphanumeric characters" }
  ```

- **contactEmail**: If the email is invalid:
  ```json
  { "contactEmail": "Enter a valid email address" }
  ```

- **contactPhone**: If the phone number is not exactly 10 digits:
  ```json
  { "contactPhone": "Phone number must be exactly 10 digits" }
  ```

- **pinCode**: If the pin code is not exactly 6 digits:
  ```json
  { "pinCode": "PinCode must be exactly 6 digits" }
  ```

## Important Notes

- The `createdOn` field is populated by the server using the server's current timestamp. Any user input for this field will be discarded.
- All fields except `contactEmail` and `createdOn` are required for creating a training center.
