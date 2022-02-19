import java.util.Objects;
import java.util.Set;


public class Category {

    public Category() {
    }

    public Category(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", products=" + products + '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    private long id = 1L;//не совпадает с именем столбца в базе данных
    private String name;//совпадает с именем столбца в базе данных
    //список товаров, которые относятся к текущей (this) категории
    private Set<Product> products;// ключ, значение (Первичный ключ, значение)

}

