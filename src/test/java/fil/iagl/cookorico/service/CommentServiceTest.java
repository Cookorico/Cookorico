package fil.iagl.cookorico.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.dao.CommentDao;
import fil.iagl.cookorico.service.impl.CommentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest extends AbstractCookoricoTest {
	
	@InjectMocks
	private CommentServiceImpl commentService;
	
	@Mock
	private CommentDao commentDao;

	public CommentServiceTest() throws Exception {
		super();
	}
	
	@Test
	public void testGetAllComments() {
		commentService.getAllComments();
		
		Mockito.verify(commentDao, Mockito.times(1)).getAllComments();
	}
	
	@Test
	public void testGetAllCommentsByIdRecipe() {
		commentService.getAllCommentsByIdRecipe(1);
		
		Mockito.verify(commentDao, Mockito.times(1)).getAllCommentsByIdRecipe(1);
	}

}
