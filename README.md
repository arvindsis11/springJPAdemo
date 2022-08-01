## #Spring Boot ManyToOne Unidirectional Mapping(Student --> College) Using Annotations

1. In Many-To-One Unidirectional mapping, one table has a foreign key column that references the primary key of associated table.
   By Unidirectional relationship means only one side navigation is possible (STUDENT to COLLEGE in this example).

2. Many students can enroll at one College. And one College can have many students.

## Student.java,Faculty.java,Employee.java

@ManyToOne(optional = false,cascade = CascadeType.ALL)\
@JoinColumn(name = "c_id")#college_id\
private University university;

## Explanation:

1. @ManyToOne indicates that Many student tuples can refer to one College tuple.
Also note that we have provided optional=false means this relationship becomes mandatory , no student row can be saved without a College tuple reference.


@JoinColumn says that there is a column c_id(i.e. college id) in Student table which will refer(foreign key) to primary key of the College table.
In this example only Student to College entity navigation is possible. Not viceversa.
In practice, however, you are free to use query language to find all the student for a given College.\
cascade = CascadeType.ALL indicates that, once we start any operation(CURD) on student table , it will reflects to College table.\
Please refer to PostManSpecs.txt for more info.

# other specifications:
1. java version : 11
2. database : h2 database

# CRUD OPERATIONS:
1. CREATE Operation: It performs the INSERT statement to create a new record.
2. READ Operation: It reads table records based on the input parameter.
3. UPDATE Operation: It executes an update statement on the table. It is based on the input parameter.
4. DELETE Operation: It deletes a specified row in the table. It is also based on the input parameter.

# SWAGGER CONFIGURATION:
1. create Docket:
```java
 @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).build()
                .apiInfo(metaData());

    }
```
2. Add this dependencies to pom.xml:
```xml
<dependency>
         <groupId>io.springfox</groupId>
         <artifactId>springfox-swagger2</artifactId>
         <version>2.6.1</version>
         <scope>compile</scope>
      </dependency>
      <dependency>
         <groupId>io.springfox</groupId>
         <artifactId>springfox-swagger-ui</artifactId>
         <version>2.6.1</version>
         <scope>compile</scope>
      </dependency>
```
note: use exact version. in case of any error add this line to application.properties:
```properties
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```
error might occure if you use swagger v3 or above because it doesn't supports matcher.
