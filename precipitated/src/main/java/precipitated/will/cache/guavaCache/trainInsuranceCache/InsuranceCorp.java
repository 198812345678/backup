package precipitated.will.cache.guavaCache.trainInsuranceCache;

/**
 * Created by will on 17/7/15.
 */
public class InsuranceCorp {

    private String corpName;

    private String corpCode;

    public InsuranceCorp(String corpName, String corpCode) {
        this.corpName = corpName;
        this.corpCode = corpCode;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }
}
