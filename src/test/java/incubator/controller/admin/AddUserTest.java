package incubator.controller.admin;

import incubator.entity.Role;
import incubator.service.interfaces.RoleService;
import incubator.service.interfaces.UserService;
import incubator.service.serviceForSecurity.UserDetailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddUserTest {
    @InjectMocks
    AddUser addUser;

    @Mock
    UserDetailServiceImpl userDetailService;
    @Mock
    RoleService roleService;

    MockMvc mockMvc;
    Role role;

    public void roleInit(){
        role = new Role();
        role.setRoleId(3);
        role.setUser('1');
        role.setTutor('0');
        role.setAdmin('0');
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addUser).build();
    }

    @Test
    public void addUserGetTest() throws Exception {
        when(roleService.getRoleById(3)).thenReturn(role);

        mockMvc.perform(get("/admin/addUser/"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addUser"));
    }
    @Test
    public void addUserPostTest() throws Exception {
        when(roleService.getRoleById(3)).thenReturn(role);

        mockMvc.perform(post("/admin/addUser/")
        .param("firstName", "fName")
        .param("lastName", "lName")
        .param("login", "Login")
        .param("password","password")
        .param("roleId", "3")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addUser"));
    }
}
