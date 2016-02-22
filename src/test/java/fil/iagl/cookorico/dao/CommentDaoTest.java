package fil.iagl.cookorico.dao;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.entity.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoTest extends AbstractCookoricoTest {
	
	public CommentDaoTest() throws Exception {
		super();
	}

	@Autowired
	private CommentDao commentDao;
	
	@Test
	public void testGetAllCommentsByIdRecipe() {
		// given
		
		// when
		final List<Comment> commentForIdRecipe1 = commentDao.getAllCommentsByIdRecipe(1);
		final List<Comment> commentForIdRecipe2 = commentDao.getAllCommentsByIdRecipe(2);
		
		// then
		Assertions.assertThat(commentForIdRecipe1).hasSize(2);
		Assertions.assertThat(commentForIdRecipe2).hasSize(1);
	}

}
