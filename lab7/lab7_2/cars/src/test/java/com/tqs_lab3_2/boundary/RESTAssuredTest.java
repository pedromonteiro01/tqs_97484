package com.tqs_lab3_2.boundary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.*;


import com.tqs_lab3_2.service.*;
import com.tqs_lab3_2.boundary.*;
import com.tqs_lab3_2.data.*;

@WebMvcTest(CarController.class)
public class RESTAssuredTest {
    @Autowired
    private MockMvc mvcClient;

    @MockBean
    private CarManagerService carService;

    @BeforeEach
    void setup () {
      RestAssuredMockMvc.mockMvc(mvcClient);
    }

    @Test
    public void testPostCar() throws Exception {
        Car c1 = new Car("car1", "model1");

        when(carService.save(Mockito.any())).thenReturn(c1);

        RestAssuredMockMvc
            .given().header("Content-Type", "application/json\r\n").body(JsonUtils.toJson(c1))
            .when().post("/api/car")
            .then().body("model", equalTo(c1.getModel()));

        verify(carService, times(1)).save(c1);
    }

    @Test
    void testReturnCarDetailsIfCarExists() throws Exception {
        Car c1 = new Car("car1", "model1");
    
        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.of(c1));
    
        RestAssuredMockMvc
            .given().when()
            .get("/api/car/1")
            .then().body("model", equalTo(c1.getModel()));
        
        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }

    @Test
    void testReturnForInvalidCar() throws Exception {
        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.empty());
    
        RestAssuredMockMvc
            .given().when()
            .get("/api/car/1")
            .then().assertThat().statusCode(404);
    
        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }
}
