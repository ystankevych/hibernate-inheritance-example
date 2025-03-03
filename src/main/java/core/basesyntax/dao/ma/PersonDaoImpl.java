package core.basesyntax.dao.ma;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.model.ma.Person;
import org.hibernate.SessionFactory;

public class PersonDaoImpl extends AbstractDao implements PersonDao {
    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Person save(Person person) {
        try {
            sessionFactory.inTransaction(s -> s.persist(person));
            return person;
        } catch (Exception e) {
            throw new RuntimeException("Can't add person to the DB", e);
        }
    }
}
