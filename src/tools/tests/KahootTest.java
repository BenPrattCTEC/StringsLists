

package tools.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tools.model.Kahoot;

public class KahootTest
{

	private Kahoot tested;
	
	@Before
	public void setUp() throws Exception
	{
		tested = new Kahoot();
	}

	@After
	public void tearDown() throws Exception
	{
		tested = null;
	}

	@Test
	public void testKahoot()
	{
		assertTrue("Default creator name is too short", tested.getCreator().length() > 3);
	}

	@Test
	public void testKahootStringIntString()
	{
		tested = new Kahoot("Sample", 0, "");
		assertTrue("Creator name not being set", tested.getCreator().equals("Sample"));
	}

	@Test
	public void testToString()
	{
		assertFalse("The toString method has not been overridden.", tested.toString().contains("@"));
	}

	@Test
	public void testGetCreator()
	{
		assertNotNull("Creator not initialized.", tested.getCreator());
		assertTrue("Minimum creator length not met.", tested.getCreator().length() > 4);
	}

	@Test
	public void testGetTopic()
	{
		assertNotNull("Topic not initialized.", tested.getTopic());
		assertTrue("Minimum topic length not met.", tested.getTopic().length() > 5);
	}

}
