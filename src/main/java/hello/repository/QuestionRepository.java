package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hello.model.Question;

@Service
@Component
public interface QuestionRepository  extends CrudRepository<Question, Long>{
	
	public Question findByTitle(String title);
	public Question findById(long id);
	
}
