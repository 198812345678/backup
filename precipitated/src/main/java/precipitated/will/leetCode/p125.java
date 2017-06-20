package precipitated.will.leetCode;

import java.util.Stack;

/**
 * Created by will on 17/6/4.
 */
public class p125 {

    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        //边界
        if(s == null || s.length() < 2) {
            return true;
        }

        //辅助栈
        Stack<Item> stack = new Stack<Item>();

        int index = 0;
        //循环执行
        for(int i = 0; i < s.length(); ++i) {

            Character ch = s.charAt(i);

            //如果不是字母或数字continue
            if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                //peek栈顶
                if(!stack.empty() && stack.peek().val.equalsIgnoreCase(String.valueOf(ch))) {
                    stack.pop();
                } else if(!stack.empty() && stack.size() > 1){
                    Item top = stack.pop();
                    Item second = stack.pop();
                    if(second.val.equalsIgnoreCase(String.valueOf(ch))) {
                        stack.push(top);
                    } else {
                        stack.push(second);
                        stack.push(top);
                        stack.push(new Item(String.valueOf(ch), index));
                    }

                } else {
                    stack.push(new Item(String.valueOf(ch), index));
                }

                index++;
                //当前位置与栈顶equals则pop
                //else则push
            }


        }

        if(stack.size() != 1 && stack.size() != 0) {
            return false;
        }

        if(stack.size() == 0) {
            return true;
        }

        //return 栈空或只有一个元素
        Item item = stack.pop();
        if(item.index == index / 2) {
            return true;
        }

        return false;

    }

    static class Item{
        String val;

        int index;

        public Item(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
