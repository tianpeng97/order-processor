package com.gigashad.tpeng.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "inventory",
        url = "${inventory.url}",
        path = "/api/inventory"
)
public interface InventoryClient {
    @GetMapping
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
