package com.springbootproject.possystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class) //hibernate-type-5 dependency
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @Column(name="order_id",length = 255)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
}
