# Book details example 


This is the source code for the "Getting started with GraphQL Java and Spring Boot" which 
is available here: https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/

To test, **POST** query to http://localhost:8080/graphql with below Body content:
```
query {
  bookById(id: "book-1") {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```