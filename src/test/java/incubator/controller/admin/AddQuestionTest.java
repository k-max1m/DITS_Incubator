package incubator.controller.admin;

import incubator.entity.Literature;
import incubator.entity.Question;
import incubator.entity.Test;
import incubator.entity.Topic;
import incubator.service.interfaces.QuestionService;
import incubator.service.interfaces.TestService;
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

public class AddQuestionTest {
    @InjectMocks
    AddQuestion addQuestion;
    @Mock
    QuestionService questionService;
    @Mock
    TestService testService;

    Literature literature;
    Question question;
    Test test;
    Topic topic;
    List<Test> testList;
    MockMvc mockMvc;

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
        test = new Test();
        test.setTopic(topic);
        test.setDescription("descriptionTest");
        test.setName("TestName");
        test.setTestId(TEST_ID);
    }

    public void initQuestion() {
        question = new Question();
        question.setTest(test);
        question.setDescription("descriptionQuestion");
        question.setQuestionId(QUESTION_ID);
    }

    public void initTestList(){
        testList = new ArrayList<>();
        testList.add(test);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addQuestion).build();
        initTopic();
        initTest();
        initQuestion();
    }

    @org.junit.jupiter.api.Test
    public void addQuestionGetTest() throws Exception {
        when(testService.getAll()).thenReturn(testList);

        mockMvc.perform(get("/admin/addQuestion/")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addQuestion"));
    }

    @org.junit.jupiter.api.Test
    public void addQuestionPostTest() throws Exception {
        when(testService.getById(TEST_ID)).thenReturn(test);
        when(testService.getAll()).thenReturn(testList);

        mockMvc.perform(post("/admin/addQuestion/")
                .param("testId", "1")
                .param("description", "description"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addQuestion"));
    }
}
