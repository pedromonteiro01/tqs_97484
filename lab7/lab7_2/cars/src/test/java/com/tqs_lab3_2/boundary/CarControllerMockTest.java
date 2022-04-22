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
public class CarControllerMockTest {
    @Autowired
    private MockMvc mvcClient;

    @MockBean
    private CarManagerService carService;

    @Test
    public void testCarCreate() throws IOException, Exception {
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
    public void testReturnCarDetailsIfCarExists() throws Exception {
        Car c1 = new Car("car1", "m1");

        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.of(c1));

        mvcClient.perform(
            get("/api/car/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.model", is(c1.getModel())));
    
        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }

    @Test
    public void testReturnForInvalidCar() throws Exception {
        when(carService.getCarDetails(Mockito.anyLong())).thenReturn(Optional.empty());

        mvcClient.perform(get("/api/car/25"))
        .andExpect(status().isNotFound());

        verify(carService, times(1)).getCarDetails(Mockito.anyLong());
    }
}
