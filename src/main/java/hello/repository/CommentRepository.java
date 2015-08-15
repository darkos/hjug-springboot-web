package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Comment;

public interface CommentRepository  extends CrudRepository<Comment, Long>{
	
	public Comment findById(long id);
	
}
