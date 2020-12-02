package incubator.controller.admin;

import incubator.entity.Question;
import incubator.entity.Test;
import incubator.entity.Topic;
import incubator.service.interfaces.TestService;
import incubator.service.interfaces.TopicService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddTestTest {
    @InjectMocks
    AddTest addTest;
    @Mock
    TestService testService;
    @Mock
    TopicService topicService;

    Question question;
    Test test;
    Topic topic;
    List<Topic> topicList;

    MockMvc mockMvc;

    final int TEST_ID = 1;
    final int TOPIC_ID = 1;

    public void initTopicList(){
        topicList = new ArrayList<>();
        topicList.add(topic);
    }

    public void initTopic(){
        topic = new Topic();
        topic.setName("topicName");
        topic.setDescription("descriptionTopic");
        topic.setTopicId(TOPIC_ID);
    }

    public void initTest(){
        test = new Test();
        test.setTopic(topic);
        test.setDescription("descriptionTest");
        test.setName("TestName");
        test.setTestId(TEST_ID);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addTest).build();
        initTopic();
        initTest();
        initTopicList();
    }

    @org.junit.jupiter.api.Test
    public void addTopicGetTest() throws Exception {
        when(topicService.getAllTopic()).thenReturn(topicList);

        mockMvc.perform(get("/admin/addTest/")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addTest"));
    }

    @org.junit.jupiter.api.Test
    public void addTestPostTest() throws Exception {
        when(topicService.getById(TOPIC_ID)).thenReturn(topic);
        when(topicService.getAllTopic()).thenReturn(topicList);

        mockMvc.perform(post("/admin/addTest/")
                .param("topicId", "1")
                .param("description", "description")
                .param("name", "testName"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addTest"));
    }
}
