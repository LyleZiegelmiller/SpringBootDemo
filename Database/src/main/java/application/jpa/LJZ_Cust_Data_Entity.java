package application.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ljz_cust_data2") // If I change this to ljz_cust_data, jdbcTemplate reports 0 rows in database.
public class LJZ_Cust_Data_Entity
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long entityId;
    
    @Column(name = "NAME")
    public String name;
    
    /** 
     * Returns the id for this account.
     */
    public Long getEntityId() {
        return entityId;
    }

    public LJZ_Cust_Data_Entity ( Long entityId, String name )
    {
        super ();
        this.entityId = entityId;
        this.name = name;
    }

    public LJZ_Cust_Data_Entity ()
    {
        super ();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the name
     */
    public String getName ()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName ( String name )
    {
        this.name = name;
    }

    /**
     * @param entityId the entityId to set
     */
    public void setEntityId ( Long entityId )
    {
        this.entityId = entityId;
    }
}
