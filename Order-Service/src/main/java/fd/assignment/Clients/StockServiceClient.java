package fd.assignment.Clients;

import DTO.Entities.stock.stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "http://localhost:8084/SpringMVC/stock")
public interface StockServiceClient {

    @GetMapping("/retrieve-stock/{id}")
    stock getStockById(@PathVariable("id") Long id);
}
