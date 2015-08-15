package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Answer;
import hello.model.Comment;
import hello.model.Question;
import hello.repository.AnswerRepository;
import hello.repository.CommentRepository;
import hello.repository.QuestionRepository;

@Service
public class QuestAndAnswService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public Question createQuestion(String title, String text) {
		Question question = new Question();
		question.setTitle(title);
		question.setQuestion(text);
		return questionRepository.save(question);
	}
	
	public Question findQuestionByTitle(String title) {
		return questionRepository.findByTitle(title);
	}
	
	public Question findQuestionById(long id) {
		return questionRepository.findById(id);
	}
	
	public Answer createAnswer(String text) {
		Answer answer = new Answer();
		answer.setAnswer(text);
		return answerRepository.save(answer);
	}
	
	public Answer findAnswerById(long id) {
		return answerRepository.findById(id);
	}
	// test methods
	public Question createSampleQuestion() {
		return createQuestion("Question Title", "Question text");
	}
	
	public String deleteSampleQuestion() {
		//return createQuestion("Question Title", "Question text");
		Question q = findQuestionByTitle("Question Title");
		String title = q.getTitle();
		questionRepository.delete(q);
		return title;
	}
	
	public Question createSampleQuestionAndSampleAnswer() {
		Question question = new Question();
		question.setTitle("Question Title");
		question.setQuestion("Question text");
		Question q = questionRepository.save(question);
		Answer answer = new Answer();
		answer.setAnswer("Answer for Question Title");
		answer.setQuestion(question);
		Answer a = answerRepository.save(answer);
		return q;
		//return createQuestion("Question Title", "Question text");
	}
	
	public void loadTestData() {
		Question question = new Question();
		question.setTitle("Question Title");
		question.setQuestion("Question text");
		Question q = questionRepository.save(question);
		Answer answer = new Answer();
		answer.setAnswer("Answer for Question Title");
		answer.setQuestion(question);
		Answer a = answerRepository.save(answer);
		Comment questionCommment = new Comment();
		questionCommment.setText("Comment on Question Title");
		questionCommment.setQuestion(q);
		Comment answerComment = new Comment();
		answerComment.setText("Comment on Answer for Question Title");
		answerComment.setAnswer(a);
		Comment qc = commentRepository.save(questionCommment);
		Comment ac = commentRepository.save(answerComment);
	}
	
	public Question question() {
		return questionRepository.findById(1);
	}
	
}
