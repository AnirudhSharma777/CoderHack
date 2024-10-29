Here’s a detailed `README.md` template and steps to generate a Postman collection for your **Leaderboard API**.

---

## README.md

```markdown
# Leaderboard API

This is a RESTful API service built using **Spring Boot** and **MongoDB** to manage the leaderboard of a coding contest. The API provides functionalities to register users, update their scores, assign badges based on scores, and retrieve users in sorted order. The project also includes basic validation and error handling.

---

## Features
- **Register Users**: Register new participants for the contest.
- **Update Score**: Update user scores.
- **Badge Assignment**: Assign badges automatically based on scores:
  - `1 <= Score < 30`: **Code Ninja**
  - `30 <= Score < 60`: **Code Champ**
  - `60 <= Score <= 100`: **Code Master**
- **Retrieve Users**: Retrieve all registered users, sorted by score in descending order.
- **Deregister Users**: Remove users from the leaderboard.
- **Validation and Error Handling**: Ensures valid inputs and provides appropriate HTTP responses.

---

## Technologies Used
- **Java 23**
- **Spring Boot** (REST API)
- **MongoDB** (Database)
- **Lombok** (for boilerplate code reduction)
- **JUnit** (for unit testing)
- **Gradle** (build tool)

---

## API Endpoints

| Method | Endpoint            | Description                              | Example Request Body               |
|--------|---------------------|------------------------------------------|------------------------------------|
| GET    | `/users`            | Retrieve all registered users            | -                                  |
| GET    | `/users/{userId}`   | Retrieve details of a specific user      | -                                  |
| POST   | `/users`            | Register a new user                      | `{ "userId": "123", "username": "Anirudh" }` |
| PUT    | `/users/{userId}`   | Update the score of a specific user      | `/users/123?score=45`              |
| DELETE | `/users/{userId}`   | Deregister a user                        | -                                  |

---

## How to Run the Project

### Prerequisites
1. Install **Java 23**, **Gradle**, and **MongoDB**.
2. Make sure MongoDB is running locally or configure your **MongoDB Atlas** connection in `application.properties`.

### Steps to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd leaderboard-api
   ```
2. Build and run the project:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. The API will be available at: `http://localhost:8080`

---

## Sample Requests

### Register a User
**Request:**
```bash
POST /users
```
**Request Body:**
```json
{
  "userId": "123",
  "username": "Anirudh"
}
```

### Update a User's Score
**Request:**
```bash
PUT /users/123?score=45
```

### Get All Users (Sorted by Score)
**Request:**
```bash
GET /users
```

### Delete a User
**Request:**
```bash
DELETE /users/123
```

---

## Error Handling

| HTTP Status | Description                |
|-------------|----------------------------|
| 400         | Invalid input data         |
| 404         | User not found             |
| 409         | User already exists        |
| 500         | Internal server error      |

---

## Unit Tests
This project includes **JUnit tests** to ensure the correct functionality of the leaderboard system. To run the tests:
```bash
mvn test
```

---

## Postman Collection

You can use the following **Postman Collection** to test the API. Import the collection to Postman using this link:

[Leaderboard API Postman Collection](https://www.getpostman.com/collections/abc123)  
*(Replace the link with the actual shareable Postman link)*

---

## License
This project is open-source and available under the MIT License.
```

---

## How to Generate and Share the Postman Collection

1. **Open Postman** and create a new **Collection** named **Leaderboard API**.
2. Add the following requests to your collection:
   - **GET /users**
   - **GET /users/{userId}**
   - **POST /users** with JSON body.
   - **PUT /users/{userId}** with `score` as a query parameter.
   - **DELETE /users/{userId}`**.

3. **Export the Collection**:
   - In Postman, click the **three dots** next to your collection and select **Export**.
   - Choose **Collection v2.1** and save it as `LeaderboardAPI.postman_collection.json`.

4. **Upload the Collection** to a public location (like **GitHub** or **Postman**).
   - If using **GitHub**, commit the JSON file to your repository.
   - If using **Postman**, click **Share** on your collection, enable **Public Link**, and copy the link.

5. **Add the Postman Link** to your `README.md` under the **Postman Collection** section.

---

This completes the `README.md` and Postman setup. Let me know if you encounter any issues!