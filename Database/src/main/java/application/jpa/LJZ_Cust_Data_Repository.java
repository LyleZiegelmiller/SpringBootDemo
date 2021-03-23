package application.jpa;

import org.springframework.data.repository.CrudRepository;

public interface LJZ_Cust_Data_Repository extends CrudRepository < LJZ_Cust_Data_Entity, Long >
{
    public LJZ_Cust_Data_Entity findFirstByName(String name);
    public Iterable<LJZ_Cust_Data_Entity> findAll();
}
