# Getting Started

### Used technologies:
* java 17
* MySql
* Maven
* spring boot 3.1.1

### How to run the application:
`java -jar -Dspring.profiles.active=dev -Ddatabase.user=<your-user-name-here> -Ddatabase.password=<your-password-here>`

###
### Swagger endpoint
`http://localhost:8080/swagger-ui/index.html#/`

### Actors (roles):
* students
* admin

### Available endpoints:
#### Courses:
| URI                               | Method | Description       | Required role |
|-----------------------------------|--------|-------------------|---------------|
| /api/course?pageNum=0&pageSize=10 | GET    | List all courses  | Public        |
| /api/course                       | POST   | Create new course | Admin         |
| /api/course                       | PUT    | Update course     | Admin         |
| /api/course                       | DELETE | Delete course     | Admin         |

#### Students:
| URI                                | Method | Description                              | Required role |
|------------------------------------|--------|------------------------------------------|---------------|
| /api/user/register                 | POST   | Register new student                     | Public        |
| /api/user/authenticate             | POST   | Authentication                           | Public        |
| /api/student?pageNum=0&pageSize=10 | GET    | List all students with courses           | Admin         |
| /api/student/course/3/assign       | PUT    | Assign a course to authenticated student | Student       |
| /api/student/course                | PUT    | Update authenticated student courses     | Student       |
| /api/student/                      | DELETE | Delete student                           | Admin         |

### Notes:
* The application comes with testing data for courses, students, and an admin data. 
* The registration API only supports students. To use the endpoints that require admin previlage, use the admin credentials
in the `/api/user/authenticate` endpoint to get access token

#### Admin credentials
| Username         | password  |
|------------------|-----------|
| admin@mail.com   | admin@123 |

#### Testing students credentials

| Username         | password    |
|------------------|-------------|
| mohamed@mail.com | mohamed@123 |
| zein@mail.com    | zein@123    |

* Access tokens expiration: 1 day
* The repo contains a postman collection with the all endpoints samples