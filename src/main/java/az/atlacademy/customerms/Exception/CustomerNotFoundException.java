package az.atlacademy.customerms.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Müştəri tapılmadı: " + id);
    }
}
