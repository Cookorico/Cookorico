package fil.iagl.cookorico.dao;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;

import fil.iagl.cookorico.AbstractCookoricoTest;
import fil.iagl.cookorico.entity.Level;

@RunWith(Parameterized.class)
public class LevelDaoTest extends AbstractCookoricoTest {
	
	@Autowired
	private LevelDao levelDao;
	
	private Integer id;
	private String label;
	private Integer xpMin;
	private Integer xpMax;
	private Integer levelNum;
	
	public LevelDaoTest(Integer id, String label, Integer xpMin, Integer xpMax, Integer levelNum) throws Exception {
		super();
		this.id = id;
		this.label = label;
		this.xpMin = xpMin;
		this.xpMax = xpMax;
		this.levelNum = levelNum;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = {
				{ 1, "Nouveau cuisinier", 0, 500, 1 },
				{ 2, "Casseur d oeuf", 501, 1001, 2 },
				{ 3, "Cuisinier toqué", 1002, 1502, 3 },
				{ 4, "Commis de cuisine", 1503, 2003, 4 },
				{ 5, "Chef étoilé", 2004, 100000, 5 },
			};
		return Arrays.asList(data);
	}
	
	@Test
	public void testGetLevelById() {
		// given
		
		// when
		final Level level = levelDao.getLevelById(id);
		
		// then
		Assertions.assertThat(level.getIdLevel()).isEqualTo(id);
		Assertions.assertThat(level.getLabelLvl()).isEqualTo(label);
		Assertions.assertThat(level.getXpMin()).isEqualTo(xpMin);
		Assertions.assertThat(level.getXpMax()).isEqualTo(xpMax);
		Assertions.assertThat(level.getLevelNum()).isEqualTo(levelNum);
	}
	
	@Test
	public void testGetLevelByXp() {
		final Level level1 = levelDao.getLevelByXP(250);
		Assertions.assertThat(level1.getLabelLvl()).isEqualTo("Nouveau cuisinier");
		
		final Level level2 = levelDao.getLevelByXP(750);
		Assertions.assertThat(level2.getLabelLvl()).isEqualTo("Casseur d oeuf");
		
		final Level level3 = levelDao.getLevelByXP(1250);
		Assertions.assertThat(level3.getLabelLvl()).isEqualTo("Cuisinier toqué");
		
		final Level level4 = levelDao.getLevelByXP(1750);
		Assertions.assertThat(level4.getLabelLvl()).isEqualTo("Commis de cuisine");
		
		final Level level5 = levelDao.getLevelByXP(2250);
		Assertions.assertThat(level5.getLabelLvl()).isEqualTo("Chef étoilé");
	}

}
