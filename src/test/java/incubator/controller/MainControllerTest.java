package incubator.controller;

import incubator.entity.Role;
import incubator.entity.User;
import incubator.service.interfaces.RoleService;
import incubator.service.serviceForSecurity.UserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import static org.mockito.Matchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

public class MainControllerTest {

    @InjectMocks
    private MainController mainController;
    @Mock
    private RoleService roleService;
    @Mock
    private BindingResult bindingResult;
    @Mock
    private UserDetailServiceImpl userDetailService;

    private MockMvc mockMvc;

    private User user;
    private Role role;

    private final String FIRST_NAME = "Test";
    private final String LAST_NAME = "Test";
    private final String LOGIN = "Test";
    private final String PASSWORD = "123";

    public void initUser(){
        user = new User();
        user.setLogin(LOGIN);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPassword(PASSWORD);
    }

    public void initRole(){
        role = new Role();
        role.setAdmin('0');
        role.setTutor('0');
        role.setUser('1');
        role.setRoleId(3);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
        initUser();
        initRole();
    }
    @Test
    public void mainPageTest() throws Exception{
        mockMvc.perform(get("/")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("login"));
    }

    @Test
    public void registrationTest() throws Exception{
        mockMvc.perform(get("/registration/")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("registration"));
    }

    @Test
    public void getRegistrationTest_successfully() throws Exception{
        when(roleService.getRoleById(eq(3))).thenReturn(role);
        when(userDetailService.save(eq(user))).thenReturn(true);
        when(bindingResult.hasErrors()).thenReturn(false);


        mockMvc.perform(post("/registration/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("registration"));
    }

    @Test
    public void getRegistrationTest_failedWithUserLogin() throws Exception{
        when(roleService.getRoleById(eq(3))).thenReturn(role);
        when(userDetailService.save(eq(user))).thenReturn(false);
        when(bindingResult.hasErrors()).thenReturn(false);


        mockMvc.perform(post("/registration/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("registration"));
    }

    @Test
    public void getRegistrationTest_failedWithBindingResult() throws Exception{
        when(roleService.getRoleById(eq(3))).thenReturn(role);
        when(userDetailService.save(eq(user))).thenReturn(true);
        when(bindingResult.hasErrors()).thenReturn(true);



        mockMvc.perform(post("/registration/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("registration"));
    }

}
