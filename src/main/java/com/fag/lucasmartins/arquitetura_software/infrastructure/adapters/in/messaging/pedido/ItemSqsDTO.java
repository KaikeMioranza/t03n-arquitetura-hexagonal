package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido;

public class ItemSqsDTO {

    private Long sku;
    private Integer amount;

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ItemSqsDTO{sku=" + sku + ", amount=" + amount + "}";
    }
}
