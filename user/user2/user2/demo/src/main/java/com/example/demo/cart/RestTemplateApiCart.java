package com.example.demo.cart;

import java.net.URI;

public class RestTemplateApiCart implements cartApi {

    @Override
    public <R> R postOperation(URI uri, Object requestObject, Class<R> rClass) {
        return null;
    }

    @Override
    public <R> R getOperation(URI uri, Class<R> rClass) {
        return null;
    }
}
