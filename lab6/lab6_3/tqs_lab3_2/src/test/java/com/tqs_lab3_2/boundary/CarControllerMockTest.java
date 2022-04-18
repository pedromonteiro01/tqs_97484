package com.tqs_lab3_2.boundary;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tqs_lab3_2.data.Car;
import com.tqs_lab3_2.service.CarManagerService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@WebMvcTest
class CarControllerMockTest {
    @Autowired
    private MockMvc mvcClient;

    @MockBean
    private CarManagerService carService;

    @Test
    void testCarCreate() throws IOException, Exception {
        Car c1 = new Car("car1", "m1");
        when(carService.save(Mockito.any())).thenReturn(c1);

        mvcClient.perform(
        post("/api/car")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtils.toJson(c1)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.model", is("m1")));

        verify(carService, times(1)).save(Mockito.any());
    }

    @Test
    void testReturnArrayForManyCars() throws Exception {
        Car c1 = new Car("car1", "m1");
        Car c2 = new Car("car2", "m2");
        Car c3 = new Car("car3", "m3");
        Car c4 = new Car("car4", "m4");

        List<Car> allCars = Arrays.asList(c1, c2, c3, c4);

        when(carService.getAllCars()).thenReturn(allCars);

        mvcClient.perform(
        get("/api/all-cars").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(4)))
        .andExpect(jsonPath("$[0].model", is(c1.getModel())))
        .andExpect(jsonPath("$[1].model", is(c2.getModel())))
        .andExpect(jsonPath("$[2].model", is(c3.getModel())))
        .andExpect(jsonPath("$[3].model", is(c4.getModel())));

        verify(carService, times(1)).getAllCars();
    }

    @Test
    void testReturnCarDetailsIfCarExists() throws Exception {
        Car c1 = new Car("car1", "m1");

        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.of(c1));

        mvcClient.perform(
            get("/api/car/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.model", is(c1.getModel())));
    
        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }

    @Test
    void testReturnForInvalidCar() throws Exception {
        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.empty());

        mvcClient.perform(get("/api/car/25"))
        .andExpect(status().isNotFound());

        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }

}
