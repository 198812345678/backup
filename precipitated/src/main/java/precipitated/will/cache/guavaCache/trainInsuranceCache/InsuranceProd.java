package precipitated.will.cache.guavaCache.trainInsuranceCache;

import java.math.BigDecimal;

/**
 * Created by will on 17/7/15.
 */
public class InsuranceProd {

    private String prodCode;

    private String prodName;

    private String corpCode;

    private BigDecimal price;

    private boolean online = true;

    public InsuranceProd(String prodCode, String prodName, String corpCode, BigDecimal price) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.corpCode = corpCode;
        this.price = price;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
