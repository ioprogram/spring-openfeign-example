package it.ioprogrammatore.feign.config;

import it.ioprogrammatore.feign.exception.BadRequestException;
import it.ioprogrammatore.feign.exception.ProductNotFoundException;
import it.ioprogrammatore.feign.exception.ProductServiceNotAvailableException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
        case 400:
            return new BadRequestException();
        case 404:
            return new ProductNotFoundException("Product not found");
        case 503:
            return new ProductServiceNotAvailableException("Product Api is unavailable");
        default:
            return new Exception("Exception while getting product details");
        }
    }
}
