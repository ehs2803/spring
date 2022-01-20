package hellojpa.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "ORDER_ID")
    Long orderid;

    @Column(name = "ITEM_ID")
    Long itemId;

    int orderPrice;
    int count;

    public Long getId() {
        return id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
