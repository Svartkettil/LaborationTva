import java.math.BigDecimal;
import java.util.Objects;

public final class Product {
    private int productId;
    private String productName;
    private BigDecimal price;
    private String category;
    private int saldo;

    public Product() {
    }

    @Override
    public String toString() {
        return productId + "| " +
                productName + "| " +
                price + "kr| " +
                category + "| " +
                saldo + "| ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(productName, product.productName) && Objects.equals(price, product.price) && Objects.equals(category, product.category);
    }

    public int productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public BigDecimal price() {
        return price;
    }

    public String category() {
        return category;
    }

    public int saldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, category, saldo);
    }

}

