package badcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterBusinessTest {

   @Test
   public void case01() {
      RegisterBusiness business = new RegisterBusiness();
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, new Speaker());
      });
      assertEquals("First name is required.", exception.getMessage());
   }

   @Test
   public void case011() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("");
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("First name is required.", exception.getMessage());
   }

   @Test
   public void case02() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Last name is required.", exception.getMessage());
   }

   @Test
   public void case021() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("");
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Last name is required.", exception.getMessage());
   }

   @Test
   public void case03() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Email is required.", exception.getMessage());
   }

   @Test
   public void case031() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      speaker.setEmail("");
      Exception exception = assertThrows(ArgumentNullException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Email is required.", exception.getMessage());
   }

   @Test
   public void case04() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      speaker.setEmail("email");
      Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
         business.register(null, speaker);
      });
   }

   @Test
   public void case05() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      speaker.setEmail("a@a.com");
      Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
   }

   @Test
   public void case06() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      speaker.setEmail("a@gmail.com");
      Exception exception = assertThrows(SaveSpeakerException.class, () -> {
         business.register(null, speaker);
      });
      assertEquals("Can't save a speaker.", exception.getMessage());
   }

   @Test
   public void case07() {
      RegisterBusiness business = new RegisterBusiness();
      Speaker speaker = new Speaker();
      speaker.setFirstName("first");
      speaker.setLastName("last");
      speaker.setEmail("a@gmail.com");
      Integer result = business.register(new SpeakerRepository() {
         @Override
         public Integer saveSpeaker(Speaker speaker) {
            // TODO Auto-generated method stub
            return 1;
         }
      }, speaker);
      assertEquals(Integer.valueOf(1), result);
   }

   @Test
   public void case08() {
      RegisterBusiness business = new RegisterBusiness();
      int fee = business.getFee(1);
      assertEquals(500, fee);
   }

   @Test
   public void case09() {
      RegisterBusiness business = new RegisterBusiness();
      int fee = business.getFee(3);
      assertEquals(250, fee);
   }

   @Test
   public void case10() {
      RegisterBusiness business = new RegisterBusiness();
      int fee = business.getFee(5);
      assertEquals(100, fee);
   }

   @Test
   public void case11() {
      RegisterBusiness business = new RegisterBusiness();
      int fee = business.getFee(9);
      assertEquals(50, fee);
   }

   @Test
   public void case12() {
      RegisterBusiness business = new RegisterBusiness();
      int fee = business.getFee(10);
      assertEquals(0, fee);
   }
}
