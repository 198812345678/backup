package precipitated.will.reference;

import java.lang.ref.SoftReference;

/**
 * Created by will.wang on 2015/6/29.
 */
public class SoftReferencefTest {

    static class SoftField{
        private SoftReference<byte[]> softBytes;

        public SoftReference<byte[]> getSoftBytes() {
            if(softBytes.get() == null || softBytes.get().length == 0) {
                System.out.println("==============");
                return null;
            }

//            System.out.println("+++++++++++++++++");
            return softBytes;
        }

        public void setSoftBytes(SoftReference<byte[]> softBytes) {
            this.softBytes = new SoftReference<byte[]>(new byte[1024 * 1024]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024)+"/"+Runtime.getRuntime().freeMemory()/(1024*1024)+"/"+Runtime.getRuntime().totalMemory()/(1024*1024));
        SoftField softField = new SoftField();

        softField.setSoftBytes(null);
//        for (int i = 0; i < 100; i++) {
            byte[] fds = new byte[1024 * 1024 *2];
        System.out.println("---------" + 1 + "---------------------" + softField.getSoftBytes());

//        byte[] fds1 = new byte[1024 * 1024 *2];
//        System.out.println("---------" + 2 + "---------------------" + softField.getSoftBytes());
//
//
//        byte[] fds61 = new byte[1024 * 1024 *2];
//        System.out.println("---------" + 3 + "---------------------" + softField.getSoftBytes());
//        }

        while (true){}
    }
}
