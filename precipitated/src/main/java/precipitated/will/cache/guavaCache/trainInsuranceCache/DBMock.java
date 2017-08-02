package precipitated.will.cache.guavaCache.trainInsuranceCache;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by will on 17/7/15.
 */
public class DBMock {

    public static List<InsuranceCorp> corpList = Lists.newLinkedList();

    public static List<InsuranceProd> prodList = Lists.newLinkedList();

    static {
        init();
    }

    private static void init() {
        InsuranceCorp corp1 = new InsuranceCorp("公司1", "corp1");
        InsuranceCorp corp2 = new InsuranceCorp("公司2", "corp2");
        InsuranceCorp corp3 = new InsuranceCorp("公司3", "corp3");
        corpList.add(corp1);
        corpList.add(corp2);
        corpList.add(corp3);

        InsuranceProd prod1 = new InsuranceProd("prod1", "产品1", corp1.getCorpCode(), new BigDecimal(20));
        InsuranceProd prod2 = new InsuranceProd("prod2", "产品2", corp1.getCorpCode(), new BigDecimal(5));
        InsuranceProd prod3 = new InsuranceProd("prod3", "产品3", corp2.getCorpCode(), new BigDecimal(10));
        InsuranceProd prod4 = new InsuranceProd("prod4", "产品4", corp2.getCorpCode(), new BigDecimal(20));
        InsuranceProd prod5 = new InsuranceProd("prod5", "产品5", corp3.getCorpCode(), new BigDecimal(20));
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);
        prodList.add(prod4);
        prodList.add(prod5);
    }


    public static void offlineProd(int index) {
        if(index >= 0 && index < prodList.size()) {
            prodList.get(index).setOnline(false);
        }
    }

    public static void onlineProd(int index) {
        if(index >= 0 && index < prodList.size()) {
            prodList.get(index).setOnline(true);
        }
    }
}
