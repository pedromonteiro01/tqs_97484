**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**Email:** pmapm@ua.pt <br>

## Lab3.1

a) Identify a couple of examples on the use of AssertJ expressive methods chaining.
- We can find some of AssertJ expressive methods chaining examples on:
    - B_EmployeeService-UnitText.java :
        - assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
        - assertThat(fromDb.getName()).isEqualTo("john");
    - D_EmployeeRestControllerIT.java
        - assertThat(found).extracting(Employee::getName).containsOnly("bob");
    - E_EmployeeRestControllerTemplateIT.java
        - assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        - assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");

b) Identify an example in which you mock the behavior of the repository (and avoid involving a database). 
-  when(service.save(Mockito.any())).thenReturn(alex);
<br>

c) What is the difference between standard @Mock and @MockBean?
Both annotations create mock objects but with a slightly different purpose.
- @Mock:
    - This annotation is a shorthand for the Mockito.mock() method. Unlike the mock() method, it's necessary enable Mockito annotations to use this annotation.
    - @Mock makes it easier to find the problem mock in case of a failure, as the name of the field appears in the failure message

- @MockBean:
    - This annotation can be used to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
    - This annotation is useful in integration tests where a particular bean needs to be mocked.

d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used? <br>
- This file has some specifications/configurations that are used by Spring framework. Is used during tests and, in our case, gives information about how to connect with the database.

e) the sample project demonstrates three test strategies to assess an API (C, D and E)developed with SpringBoot. Which are the main/key differences?
- C:
    - MockMvc provides an entry point to server-side testing. MockMvc provides an expressive API too, in which methods chaining is expected.
- D:
    - 
- E:
    - 
