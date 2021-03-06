package com.example.springdata.lazyeager.manytomany;

import com.example.springdata.AbstractUnitTest;
import com.example.springdata.repositories.lazyeager.manytomany.OwnerLERepository;
import com.example.springdata.repositories.lazyeager.manytomany.SlaveLERepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LazySlaveFetchEagerOwnerFetchTest extends AbstractUnitTest {

    // Owning Entity
    @Autowired
    private OwnerLERepository ownerRepository;

    // Slave Entity
    @Autowired
    private SlaveLERepository slaveRepository;

    /**
     * The 1st query gets the owner. After that we fetch his slaves lazily in the 2nd request.
     * For each slave we do one request to fetch his owners, creating the 3rd and 4th requests.
     */
    @Test
    @Transactional
    public void whenReadFromOwnerRepository_givenEagerOwnerFetchAndLazySlaveFetch_shouldExecuteThreeSqlRequest() {
        printMessage("Owner Call");
        OwnerLE owner = ownerRepository.findById(1L).get();
        printMessage("Slave Call");
        Set<SlaveLE> slaves = owner.getSlaves();
        assertEquals(2, slaves.size());
        printMessage("End of Calls");
    }

    /**
     * All the owners of the slave are fetched eagerly in one request.
     */
    @Test
    public void whenReadFromSlaveRepository_givenEagerOwnerFetchAndLazySlaveFetch_shouldExecuteOneSqlRequest() {
        printMessage("Slave Call");
        SlaveLE slave = slaveRepository.findById(1L).get();
        printMessage("Owner Call");
        Set<OwnerLE> owners = slave.getOwners();
        assertEquals(1, owners.size());
        printMessage("End of Calls");
    }
}
