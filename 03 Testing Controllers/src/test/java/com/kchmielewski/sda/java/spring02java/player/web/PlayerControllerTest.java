package com.kchmielewski.sda.java.spring02java.player.web;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

public class PlayerControllerTest {
    private final PlayerController controller = new PlayerController();
    private final Model model = mock(Model.class);

    @Test
    public void superFancyMethodReturnsWhatItShouldReturn() {
        assertThat(controller.doSomethingSpecial(model)).isEqualTo("players");
    }
}