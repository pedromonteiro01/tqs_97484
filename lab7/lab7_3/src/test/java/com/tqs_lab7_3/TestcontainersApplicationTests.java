package com.tqs_lab7_3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// Followed example avaible at:
// -  https://www.youtube.com/watch?v=-mYJKwrySOw

@Testcontainers
@SpringBootTest
class ApplicationTests {

  @Container
  public static PostgreSQLContainer container = new PostgreSQLContainer<>("postgres:alpine")
    .withUsername("duke")
    .withPassword("password")
    .withDatabaseName("test");

  @Autowired
  private BookRepository bookRepository;

  // requires Spring Boot >= 2.2.6
  @DynamicPropertySource
  static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.password", container::getPassword);
    registry.add("spring.datasource.username", container::getUsername);
  }

  @Test
  void testCount() {
	assertEquals(4, bookRepository.count());
  }


  @Test
  void testPost() {
    
    Book b6 = new Book();
    b6.setName("Book6");

    bookRepository.save(b6);

    Book retrieved = bookRepository.getById(6L);

    assertNotEquals(null, retrieved);
    assertEquals("Book6", retrieved.getName());

  }

}