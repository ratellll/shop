package com.example.shop.Entity;


import com.example.shop.constant.ItemSellStatus;
import com.example.shop.dto.ItemFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드

    @Column(nullable = false, length = 50)
    private String itemNm;//상품이름

    @Column(name = "itemSize", nullable = false)
    private int itemSize;//상품사이즈

    @Column(name = "price", nullable = false)
    private int price;//가격

    @Column(nullable = false)
    private int stockNumber;//재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;//상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;// 상품판매상

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }


}
