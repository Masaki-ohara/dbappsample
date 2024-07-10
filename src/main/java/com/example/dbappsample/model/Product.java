package com.example.dbappsample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products") // テーブル名は複数形にしましょう
public class Product {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) アノテーションは、JPA（Java Persistence API）を使用してデータベースのエンティティの主キー（ID）を自動生成する方法を指定するためのものです。具体的には、次のような意味があります：
    // strategy: 主キーの生成方法を指定します。GenerationType.IDENTITY は、データベースの自動増分（auto-increment）機能を利用して主キーを生成する方法です。この方法を使うと、データベースがエンティティを永続化（保存）する際に自動的に主キーが生成されます。
    // GenerationType.IDENTITY: 主キーの生成方法の一つで、通常はデータベースのテーブルにおいて、主キー列が自動的にインクリメントされる方式を指します。この方法は、主にMySQLやPostgreSQLなどの一部のリレーショナルデータベースで使用されます。
    // このアノテーションは、JPAによってエンティティクラスがデータベーステーブルとマッピングされる際に、どのようにして主キーを生成するかを指定する重要な役割を果たします。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 名前は重複禁止(unique = true)
    // nameカラムはnull禁止(nullable = false)
    @Column(nullable = false, unique = true)
    private String name;

    // ここでは@Columnとしているが
    // null禁止も重複禁止もしないなら@Columnアノテーションを省略できる
    @Column
    private int price;

    // 処理の無いコンストラクタは必ず書く
    public Product(){
    }

    // 全パラメータのコンストラクタは必須ではないが書いておく
    public Product(Long id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
