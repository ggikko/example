package me.ggikko.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.ggikko.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Park Ji Hong, ggikko.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AccountControllerTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createAccount() throws Exception {

        AccountDto.Create createDto = new AccountDto.Create();
        createDto.setUsername("ggikko");
        createDto.setPassword("password");

        ResultActions result = mockMvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDto)));

        result.andDo(print());
        result.andExpect(status().isCreated());
    }

    @Test
    public void createAccount_badRequest() throws Exception {
        AccountDto.Create create = new AccountDto.Create();
        create.setUsername(" ");
        create.setPassword("baba");

        ResultActions result = mockMvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(create)));

        result.andDo(print());
        result.andExpect(status().isBadRequest());

    }

}