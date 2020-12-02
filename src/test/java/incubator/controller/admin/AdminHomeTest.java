package incubator.controller.admin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminHomeTest {
    @InjectMocks
    AdminHome adminHome;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminHome).build();
    }

    @Test
    public void adminHomeTest() throws Exception {
        mockMvc.perform(get("/admin/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/admin_home"));
    }
}
