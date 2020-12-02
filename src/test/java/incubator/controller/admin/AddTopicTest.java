package incubator.controller.admin;

import incubator.entity.Topic;
import incubator.service.interfaces.TopicService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddTopicTest {
    @InjectMocks
    AddTopic addTopic;
    @Mock
    TopicService topicService;

    Topic topic;

    MockMvc mockMvc;

    final int TOPIC_ID = 1;


    public void initTopic(){
        topic = new Topic();
        topic.setName("topicName");
        topic.setDescription("descriptionTopic");
        topic.setTopicId(TOPIC_ID);
    }


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addTopic).build();
        initTopic();
    }

    @org.junit.jupiter.api.Test
    public void addTopicGetTest() throws Exception {
        mockMvc.perform(get("/admin/addTopic/")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addTopic"));
    }

    @org.junit.jupiter.api.Test
    public void addTestPostTest() throws Exception {
        mockMvc.perform(post("/admin/addTopic/")
                .param("description", "description")
                .param("name", "testName"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addTopic"));
    }
}
