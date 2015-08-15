package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Answer;
import hello.model.Comment;
import hello.model.Question;
import hello.repository.QuestionRepository;
import hello.service.QuestAndAnswService;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	public QuestAndAnswService qandaService;
	
	@Autowired
	public QuestionRepository questionRepository;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping("/question")
	public Question question(@RequestParam(value = "id", defaultValue = "1") long id) {
		return questionRepository.findById(id);
	}
	
	@RequestMapping("/questions")
	public Iterable<Question> questions() {
		return questionRepository.findAll();
	}
	
	@RequestMapping("/answers")
	public List<Answer> answers(@RequestParam(value = "id") long id) {
		Question q = questionRepository.findById(id);
		return q.getAnswers();
	}
	
	@RequestMapping("/questioncomments")
	public List<Comment> questioncomments(@RequestParam(value = "id") long id) {
		Question q = questionRepository.findById(id);
		return q.getComments();
	}

}
