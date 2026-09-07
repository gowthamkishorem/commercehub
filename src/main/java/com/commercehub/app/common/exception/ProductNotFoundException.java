package com.commercehub.app.common.exception;


    public class ProductNotFoundException extends RuntimeException {

        public ProductNotFoundException(String message) {
            super(message);
        }
}
