package at.htl.springdemo.db;

import at.htl.springdemo.bl.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}