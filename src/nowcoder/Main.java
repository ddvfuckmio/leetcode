package nowcoder;

public class Main {
    public static void main(String[] args) {
        try{
			throw new RuntimeException();
		}catch (Exception e){
        	System.out.println("1");
        	return;
		}finally{
			System.out.println("fin...");
		}
    }
}
