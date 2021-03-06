package com.kchmielewski.sda.java.spring05java.player.web;

import com.kchmielewski.sda.java.spring05java.player.model.Player;
import com.kchmielewski.sda.java.spring05java.player.service.PlayerService;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PlayerControllerTest {
    private final PlayerService service = new PlayerService();
    private final PlayerController controller = new PlayerController(service);
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void display() throws Exception {
        MvcResult result = mvc.perform(get("/display")).andExpect(status().isOk()).andReturn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
        softly.assertThat(service.all()).hasSize(0);
        softly.assertAll();
    }

    @Test
    public void add() throws Exception {
        MvcResult result = mvc.perform(post("/add").param("name", "Name").param("surname", "Surname"))
                .andExpect(status().isOk()).andReturn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
        softly.assertThat(service.all()).hasSize(1);
        softly.assertAll();
    }

    @Test
    public void remove() throws Exception {
        service.add(new Player("Abc", "Def"));

        MvcResult result = mvc.perform(post("/remove").param("name", "Abc").param("surname", "Def"))
                .andExpect(status().isOk()).andReturn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
        softly.assertThat(service.all()).hasSize(0);
        softly.assertAll();
    }
}