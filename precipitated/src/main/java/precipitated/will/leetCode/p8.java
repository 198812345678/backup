package precipitated.will.leetCode;


/**
 * Created by will on 17/6/1.
 */
public class p8 {

    public static void main(String[] args) {
//        String str = null;
//        StringBuilder sb = new StringBuilder();
//        System.out.println(Integer.valueOf("2147483648"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(String.valueOf(Integer.MIN_VALUE).compareTo("-11919730356"));
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String str) {
        if(str == null || str.length() <= 0) {
            return 0;
        }

        int i = 0;
        while(str.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }


        int num = 0;
        for(int j = i; j < str.length(); ++j) {

            if(str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(j) - '0' > 7)) {
                    if(sign > 0) {
                        return Integer.MAX_VALUE;
                    }
                    return Integer.MIN_VALUE;
                }

                num = 10 * num + str.charAt(j) - '0';
                continue;
            }
            break;
        }

        return num * sign;
    }
}
