import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Random6 extends Random {
   private static final long serialVersionUID = 3417321260532284355L;

   @Override
   public int nextInt(int bound) {
      return 6;
   }
}

public class IdGenerateServiceTest {
   @Test
   public void getData() {
      Random stub = new Random6(); // Dependency
      IdGenerateService service = new IdGenerateService();
      // 2. Setter/field/property Injection
      service.setRandom(stub);
      String result = service.getData();
      assertEquals("CODE6", result);
   }

   @Test
   public void getData2() {
      SpyRandom spy = new SpyRandom(); // Dependency
      IdGenerateService service = new IdGenerateService();
      service.setRandom(spy);
      service.getData();
      // Assert
      spy.verify(1);
   }

   class SpyRandom extends Random {
      private static final long serialVersionUID = -3459474243472459623L;
      private int count;

      @Override
      public int nextInt(int bound) {
         count++;
         return 6;
      }

      public void verify(int expectedCount) {
         assertTrue(count == expectedCount);
      }
   }
}