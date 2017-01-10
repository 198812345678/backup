package precipitated.will;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
//    public static void main(String... args) throws Exception {
//        Main main = new Main();
//        main.enableHangupSupport();
//        main.addRouteBuilder(new MyRouteBuilder());
//        main.run(args);
//    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                continue;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("finally");
            }
        }
    }
}

