package com.example.shop.Entity;


import com.example.shop.constant.itemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드

    @Column(nullable = false, length = 50)
    private String itemNm;//상품이름

    @Column(nullable = false, length = 50)
    private Long itemSize;//상품사이즈

    @Column(name = "price", nullable = false)
    private int price;//가격

    @Column(nullable = false)
    private int stockNumber;//재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;//상품 상세 설명

    @Enumerated(EnumType.STRING)
    private itemSellStatus itemSellStatus;// 상품판매상


    private LocalDateTime regTime;// 등록시간

    private LocalDateTime updateTime; //수정시간

}
