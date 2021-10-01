
public class MyRange {

   private String input;

   public MyRange(String input) {
      this.input = input;
   }

   public boolean startWithInclude() {
      return input.startsWith("[");
   }

   public int getStart() {
      char start = input.charAt(1);
      if (startWithInclude()) {
         return start - 48;
      }
      return start - 47;
   }

   public void validate() {
      if (!input.startsWith("[") && !input.startsWith("(")) {
         throw new InputInvalidException("Input error");
      }
   }
}
