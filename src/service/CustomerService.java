package service;

import dao.CustomerDao;
import model.Customer;

public class CustomerService {
    CustomerDao customerDao = new CustomerDao();

    public Customer findCustomer(String userName,String pass){
        return customerDao.findCustomer(userName,pass);
    }
    public void save(Customer customer){
        customerDao.saveCustomer(customer);
    }

    public void update(Customer customer){
        customerDao.updateCustomer(customer);
    }
}
