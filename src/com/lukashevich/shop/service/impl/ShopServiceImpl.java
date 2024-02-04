package com.lukashevich.shop.service.impl;

import com.lukashevich.shop.dto.ProductShopDTO;
import com.lukashevich.shop.model.Product;
import com.lukashevich.shop.model.ProductShop;
import com.lukashevich.shop.model.Shop;
import com.lukashevich.shop.repository.ShopRepository;
import com.lukashevich.shop.service.ProductService;
import com.lukashevich.shop.service.ShopService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ProductService productService;

    public ShopServiceImpl(ShopRepository shopRepository, ProductService productService) {
        this.shopRepository = shopRepository;
        this.productService = productService;
    }

    @Override
    public Shop saveShop(Shop shop) throws IOException {
        return shopRepository.saveShop(shop);
    }

    @Override
    public List<Shop> getAllShops() throws IOException {
        return shopRepository.getAllShops();
    }

    @Override
    public Shop getShopById(Long id) throws IOException {
        return shopRepository.getShopById(id);
    }

    @Override
    public Shop addProductToShop(Long shopId, Long productId, Integer quantity) throws IOException {
        Shop shop = getShopById(shopId);
        ProductShop productShop = new ProductShop(productId, quantity);
        List<ProductShop> productShopList = shop.getProducts();
        if (productShopList!=null) {
            productShopList.removeIf(x -> x.getProductId().equals(productShop.getProductId()));
        }else{
            productShopList = new ArrayList<>();
        }
        productShopList.add(productShop);
        shop.setProducts(productShopList);
        return saveShop(shop);
    }

    @Override
    public List<ProductShopDTO> getProductsInShop(Long shopId) throws IOException {
        List<ProductShop> products = getShopById(shopId).getProducts();
        List<ProductShopDTO> productsDTO = new ArrayList<>();
        if (products != null){
            for (ProductShop productShop : products) {
                Product productById = productService.getProductById(productShop.getProductId());
                ProductShopDTO productShopDTO = new ProductShopDTO(productById.getId(), productById.getName(), productById.getPrice(), productShop.getQuantity());
                productsDTO.add(productShopDTO);
            }
        }else{
            System.out.println("No products in shop");
        }
        return productsDTO;
    }

}
