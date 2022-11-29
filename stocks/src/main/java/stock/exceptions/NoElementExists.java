package stock.exceptions;

public class NoElementExists extends RuntimeException {
   
    public NoElementExists(){
        super("No Web Element Exists");
    }

    public NoElementExists(String message){
        super(message);
    }
    
}
