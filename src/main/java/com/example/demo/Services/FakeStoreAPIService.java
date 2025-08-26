package com.example.demo.Services;

import com.example.demo.dto.FakeStoreAPIRequestDTO;
import com.example.demo.dto.FakeStoreAPIResponseDTO;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreAPIService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreAPIResponseDTO responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreAPIResponseDTO.class);

        if(responseDTO == null){
           throw new ProductNotFoundException("Product Not Found Exception");
        }
        return responseDTO.toProduct();
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreAPIResponseDTO[] fakeStoreAPI = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreAPIResponseDTO[].class);

        List<Product> productList = new ArrayList<>();

        for (FakeStoreAPIResponseDTO responseDTO : fakeStoreAPI) {
            productList.add(responseDTO.toProduct());
        }

        if(!productList.isEmpty()) {
            throw new ArrayStoreException("Testing Exception Handler");
        }

        return productList;

    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreAPIRequestDTO fakeStoreAPIRequestDTO = new FakeStoreAPIRequestDTO();
        fakeStoreAPIRequestDTO.setTitle(product.getTitle());
        fakeStoreAPIRequestDTO.setPrice(product.getPrice());
        fakeStoreAPIRequestDTO.setDescription(product.getDescription());
        fakeStoreAPIRequestDTO.setImage(product.getImageURL());
        fakeStoreAPIRequestDTO.setCategory(product.getCategory().getName());

        FakeStoreAPIResponseDTO responseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreAPIRequestDTO,
                FakeStoreAPIResponseDTO.class
        );

        return responseDTO.toProduct();

    }

    @Override
    public Product updateProduct(Product product) {
        FakeStoreAPIRequestDTO fakeStoreAPIRequestDTO = new FakeStoreAPIRequestDTO();
//        fakeStoreAPIRequestDTO.setId(product.getId());
        fakeStoreAPIRequestDTO.setTitle(product.getTitle());
        fakeStoreAPIRequestDTO.setPrice(product.getPrice());
        fakeStoreAPIRequestDTO.setDescription(product.getDescription());
        fakeStoreAPIRequestDTO.setImage(product.getImageURL());
        fakeStoreAPIRequestDTO.setCategory(product.getCategory().getName());

      //  FakeStoreAPIResponseDTO responseDTO = restTemplate.put("https://fakestoreapi.com/products/{id}", fakeStoreAPIRequestDTO, FakeStoreAPIResponseDTO.class);
        HttpEntity<FakeStoreAPIRequestDTO> httpEntity = new HttpEntity<FakeStoreAPIRequestDTO>(fakeStoreAPIRequestDTO);
        ResponseEntity<FakeStoreAPIResponseDTO> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + fakeStoreAPIRequestDTO.getId(),
                HttpMethod.PUT,
                httpEntity,
                FakeStoreAPIResponseDTO.class);

        return responseEntity.getBody().toProduct();

   }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) throws ProductNotFoundException {
//       FakeStoreAPIResponseDTO responseDTO =  restTemplate.delete("https://fakestoreapi.com/products/{id}");

        ResponseEntity<FakeStoreAPIResponseDTO> responceEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.DELETE,
                null,
                FakeStoreAPIResponseDTO.class);

        FakeStoreAPIResponseDTO responseDTO = responceEntity.getBody();

        if(responceEntity.getBody() == null){
            throw new ProductNotFoundException("Product Not Found");
        }
        ResponseEntity<Product> productResponseEntity =
                new ResponseEntity<>(responseDTO.toProduct(),  HttpStatus.OK);

        return productResponseEntity;

    }
}

