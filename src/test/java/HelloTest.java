import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

   @Test
   @DisplayName("เรากำลังทดสอบด้วย junit 5")
   void case01() {
      // Arrange = Given
      Hello hello = new Hello();
      // Act = When
      String result = hello.say("adsawin");
      // Assert = Then
      assertEquals("Hello adsawin", result);
   }

}
