package com.example.demo.cart;

import java.net.URI;

public interface cartApi {
    <R> R postOperation(URI uri,Object requestObject,Class<R> rClass);
    <R> R getOperation(URI uri,Class<R> rClass);

}
