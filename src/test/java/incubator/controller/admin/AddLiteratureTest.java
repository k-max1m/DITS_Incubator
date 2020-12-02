package incubator.controller.admin;

import incubator.entity.Literature;
import incubator.entity.Question;
import incubator.entity.Test;
import incubator.entity.Topic;
import incubator.service.interfaces.LiteratureService;
import incubator.service.interfaces.QuestionService;
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

public class AddLiteratureTest {
    @InjectMocks
    AddLiterature addLiterature;
    @Mock
    QuestionService questionService;
    @Mock
    LiteratureService literatureService;


    MockMvc mockMvc;
    Question question;
    Test test;
    Topic topic;
    List<Question> questionList;

    final int TEST_ID = 1;
    final int QUESTION_ID = 1;
    final int TOPIC_ID = 1;

    public void initQuestionList(){
        questionList = new ArrayList<>();
        questionList.add(question);
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

    public void initQuestion() {
        question = new Question();
        question.setTest(test);
        question.setDescription("descriptionQuestion");
        question.setQuestionId(QUESTION_ID);
    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(addLiterature).build();
        initTopic();
        initTest();
        initQuestion();
        initQuestionList();

    }

    @org.junit.jupiter.api.Test
    public void addLiteratureGetTest() throws Exception {
        when(questionService.getAllQuestion()).thenReturn(questionList);

        mockMvc.perform(get("/admin/addLiterature/")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addLiterature"));
    }

    @org.junit.jupiter.api.Test
    public void addLiteraturePostTest() throws Exception {
        when(questionService.getByQuestionId(QUESTION_ID)).thenReturn(question);
        when(questionService.getAllQuestion()).thenReturn(questionList);

        mockMvc.perform(post("/admin/addLiterature/")
                .param("questionId", "1")
                .param("description", "description"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("admin/addLiterature"));
    }
}
