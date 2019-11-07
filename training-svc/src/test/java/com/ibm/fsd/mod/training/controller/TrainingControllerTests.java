package com.ibm.fsd.mod.training.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableFeignClients(basePackages = {"com.ibm.fsd.mod"})
@AutoConfigureMockMvc
@Slf4j
public class TrainingControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAllMentorOnGoingTrainings() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v1/training/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mentors.length()").value(4))
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetAllStudentTrainingsByStatusOnGoing() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/v1/training/user")
                        .param("username", "hui@qq.com")
                        .param("status", "ONGOING"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainings.length()").value(4))
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetAllStudentTrainingsByStatusOnComplted() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/v1/training/user")
                        .param("username", "hui@qq.com")
                        .param("status", "COMPLETED"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainings.length()").value(0))
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGetAllSMentorTrainingsByStatusOnOnGoing() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/v1/training/mentor")
                        .param("username", "huimiao@cn.ibm.com")
                        .param("status", "ONGOING"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mentors.length()").value(1))
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testRating() throws Exception {
        mockMvc.perform(
                post("/v1/training/rating/3/2").param("username", "hui@qq.com"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
