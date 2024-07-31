public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Mock implementation
        return new Customer(id, "John Doe");
    }
}