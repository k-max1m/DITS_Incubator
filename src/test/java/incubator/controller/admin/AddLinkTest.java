package incubator.controller.admin;

import incubator.entity.*;
import incubator.service.interfaces.LinkService;
import incubator.service.interfaces.LiteratureService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class AddLinkTest {

    @InjectMocks
    AddLink addLink;
    @Mock
    LiteratureService literatureService;
    @Mock
    LinkService linkService;

    MockMvc mockMvc;

    Literature literature;
    Question question;
    incubator.entity.Test test;
    Topic topic;
    List<Literature> literatureList;

    final int LITERATURE_ID = 1;
    final int TEST_ID = 1;
    final int QUESTION_ID = 1;
    final int TOPIC_ID = 1;

    public void initTopic(){
        topic = new Topic();
        topic.setName("topicName");
        topic.setDescription("descriptionTopic");
        topic.setTopicId(TOPIC_ID);
    }

    public void initTest(){
        test = new incubator.entity.Test();
        test.setTopic(topic);
        test.setDescription("descriptionTest");
        test.setName("TestName");
        test.setTestId(TEST_ID);
    }

    public void initQuestion(){
        question = new Question();
        question.setTest(test);
        question.setDescription("descriptionQuestion");
        question.setQuestionId(QUESTION_ID);
    }

    public void initLiterature(){
        literature = new Literature();
        literature.setQuestion(question);
        literature.setDescription("descriptionLiterature");
        literature.setLiteratureId(LITERATURE_ID);
    }
    public void initLiteratureList(){
        literatureList = new ArrayList<>();
        literatureList.add(literature);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addLink).build();
        initTopic();
        initTest();
        initQuestion();
        initLiterature();
        initLiteratureList();
    }

    @Test
    public void addLinkGetTest() throws Exception {
        when(literatureService.getAllLiterature()).thenReturn(literatureList);

        mockMvc.perform(get("/admin/addLink/")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addLink"));
    }

    @Test
    public void addLinkPostTest() throws Exception {
        when(literatureService.getByLiteratureId(LITERATURE_ID)).thenReturn(literature);
        when(literatureService.getAllLiterature()).thenReturn(literatureList);

        mockMvc.perform(post("/admin/addLink/")
                .param("literatureId", "1")
                .param("link", "LINK"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addLink"));
    }
}
