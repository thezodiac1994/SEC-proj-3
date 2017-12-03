import static org.junit.Assert.*;
import org.junit.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;



/**
 * Class we will use to test that our code in the Example6 class works.
 * 
 * @author Matthew Hertz
 */
public class Example6Test {

  /** Instance of the "CUT" ("C"lass "U"nder "T"est). */
  private Example6 instance;

  @Before
  public void setUp() {
    instance = new Example6();
  }

  @Test
  public void testBlueButton() {
    JButton littleBoy = instance.getBlueButton();
    littleBoy.doClick();
    assertEquals(Color.BLUE, instance.getLabelColor());
  }

  @Test
  public void testGreenButton() {
    JButton treeHugger = instance.getGreenButton();
    ActionEvent ae = new ActionEvent(treeHugger, 0, null);
    instance.actionPerformed(ae);
    assertEquals(Color.GREEN, instance.getLabelColor());
  }

  @Test
  public void testRedButton() {
    JButton ridingHood = instance.getRedButton();
    ActionEvent ae = new ActionEvent(ridingHood, 0, null);
    instance.actionPerformed(ae);
    assertEquals(Color.RED, instance.getLabelColor());
  }
}
