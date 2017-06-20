package precipitated.will.basicType;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by will.wang on 2016/9/29.
 */
public class BasiTypeReferenceOpt {

    public static void main(String[] args) {
        AtomicReference<Boolean> reference = new AtomicReference<Boolean>(true);

        changeValue(reference);

        System.out.println(reference.get());

//        Reference<Boolean> booleanReference = new Reference<Boolean>() {
//        };
    }

    private static void changeValue(AtomicReference<Boolean> reference) {
        reference.set(false);
    }
}
