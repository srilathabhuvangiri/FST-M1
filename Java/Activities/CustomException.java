package Session2;

public class CustomException extends Exception{
    String message = null;
     public CustomException(String message){
         this.message = message;
     }

     public String getMessage(){
         return message;
     }

}
