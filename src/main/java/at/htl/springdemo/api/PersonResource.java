package at.htl.springdemo.api;

import at.htl.springdemo.bl.Person;
import at.htl.springdemo.db.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource
{

    private PersonRepository repository;

    public PersonResource(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> getPerson()
    {
        return repository.findAll();
    }

    @PostMapping
    public void addPerson(@RequestBody Person p)
    {
        try
        {
            repository.save(p);
        }catch(Exception e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }

    }

}
