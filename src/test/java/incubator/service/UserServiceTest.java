package incubator.service;

import incubator.entity.User;
import incubator.repository.UserRepos;
import incubator.service.interfaces.RoleService;
import incubator.service.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    @InjectMocks
    UserService userService = new UserServiceImpl();
    @Mock
    UserRepos userRepos;
    @Mock
    RoleService roleService;
    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    String USER_NAME = "User";
    String USER_PASSWORD = "123";

    User user;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        initUser();
    }

    private void initUser(){
        user = new User();
        user.setLogin(USER_NAME);
        user.setPassword(USER_PASSWORD);
    }

    @Test
    public void saveTest_successfully(){
        //stub
        when(userRepos.findByLogin(eq(user.getLogin()))).thenReturn(null);
        when(bCryptPasswordEncoder.encode(eq(user.getPassword()))).thenReturn(USER_PASSWORD);

        //call
        boolean result = userService.save(user);

        //verify
        assertEquals(true, result);
        verify(userRepos).save(user);
    }

    @Test
    public void saveTest_failed(){
        //stub
        when(userRepos.findByLogin(eq(user.getLogin()))).thenReturn(user);

        //call
        boolean result = userService.save(user);

        //verify
        assertEquals(false, result);
    }


}
