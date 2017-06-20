package precipitated.will.classLoader;

/**
 * Created by will.wang on 2016/9/28.
 */
public class ClassLoadOrdersSolution {

    public static class Inner{

        static {
            System.out.println("TestInner Static!");
        }

        public final static ClassLoadOrdersSolution testInstance = new ClassLoadOrdersSolution(3);
    }

    public static ClassLoadOrdersSolution getInstance(){
        return Inner.testInstance;
    }

    public ClassLoadOrdersSolution(int i ) {
        System.out.println("Test " + i +" Construct! ");
    }

    public static ClassLoadOrdersSolution testOut = new ClassLoadOrdersSolution(1);

    static {
        System.out.println("Test Stataic");
    }

    public static void main(String args[]){
        ClassLoadOrdersSolution t = new ClassLoadOrdersSolution(2);
        ClassLoadOrdersSolution.getInstance();
    }

//    System.out.println("Test Stataic");
//    System.out.println("Test " + 1 +" Construct! ");
//    System.out.println("Test " + 2 +" Construct! ");
//    System.out.println("TestInner Static!");
//    System.out.println("Test " + 3 +" Construct! ");
}
