package core.basesyntax.dao.ma;

import core.basesyntax.model.ma.Mentor;
import java.util.List;
import org.hibernate.SessionFactory;

public class MentorDaoImpl extends PersonDaoImpl implements MentorDao {
    public MentorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Mentor> findByAgeGreaterThan(int age) {
        try {
            return sessionFactory.fromSession(s -> s.createQuery("FROM Mentor "
            + "WHERE age > :age", Mentor.class)
                    .setParameter("age", age)
                    .getResultList());
        } catch (Exception e) {
            throw new RuntimeException("No mentor with the age greater than " + age, e);
        }
    }
}
