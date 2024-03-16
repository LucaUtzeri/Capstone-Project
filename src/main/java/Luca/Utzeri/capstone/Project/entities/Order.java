package Luca.Utzeri.capstone.Project.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID orderId;
    private String orderName;
    private double orderPrice;
    private LocalDate orderDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;


    public Order(String orderName, double orderPrice, LocalDate orderDate, String description, User userId) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.description = description;
        this.userId = userId;
    }
}
