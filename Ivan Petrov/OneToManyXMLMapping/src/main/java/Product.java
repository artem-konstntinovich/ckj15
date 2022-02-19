public class Product {

    //описываем поля в таблице
    public Product() {
    }

    public Product(String name, String description, float price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", category=" + category + '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    private long id = 1L;//не совпадает с именем столбца
    private String name;
    private String description;
    private float price;
    //описываем отношения - то, чего нет в самйо таблице
    //или это внешний ключ
    private Category category;//объект. внутри котрого
    //должна быть коллекция товаров
    //категория, которая содержит этот (this) товар
}
