package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Answer;

public interface AnswerRepository  extends CrudRepository<Answer, Long>{
	
	public Answer findById(long id);
	
}
