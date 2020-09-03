package com.example.springdata.lazyeager.onetoone;

import com.example.springdata.AbstractUnitTest;
import com.example.springdata.db.entities.lazyeager.onetoone.ChildELO;
import com.example.springdata.db.entities.lazyeager.onetoone.ParentELO;
import com.example.springdata.db.repositories.lazyeager.onetoone.ChildELORepository;
import com.example.springdata.db.repositories.lazyeager.onetoone.ParentELORepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EagerParentFetchLazyChildFetchTest extends AbstractUnitTest {

    // Child Entity
    @Autowired
    private ParentELORepository parentRepository;

    // Parent Entity
    @Autowired
    private ChildELORepository childRepository;

    /**
     * {@link Transactional} guarantees that I have an open Persistence Context (Hibernate session)
     * and I can fetch lazily the needed objects.
     */
    @Test
    public void whenReadFromParentRepository_givenEagerParentFetchAndLazyChildFetch_shouldExecuteTwoSqlRequests() {
        printMessage("Parent Call");
        ParentELO parent = parentRepository.findById(1L).get();
        printMessage("Child Call");
        ChildELO child = parent.getChildren();
        assertEquals("Child 1", child.getName());
        printMessage("End of Calls");
    }

    @Test
    public void whenReadFromChildRepository_givenEagerParentFetchAndLazyChildFetch_shouldExecuteOneSqlRequest() {
        printMessage("Child Call");
        ChildELO child = childRepository.findById(1L).get();
        printMessage("Parent Call");
        ParentELO parent = child.getParent();
        assertEquals("Parent 1", parent.getName());
        printMessage("End of Call");
    }
}
