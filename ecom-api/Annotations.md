#### Model
- @Entity
- @Table(name="<TABLE_NAME>")
- @Id
- @GeneratedValue(strategy = GenerationType.IDENTITY)
- @Column(name='')
- @OneToOneMapping

#### Controller
- @RestController
- @Autowired

- @RequestMapping("")
- @GetMapping("{id}") - @PathVariable <Type> id; `.findAll()`
- @PostMapping("") - @RequestBody; `.save()`
- @PutMapping("") - ResponseEntity; `.save()`
- @DeleteMapping("") - `.delete()`

### Repository Interface
- @Repository extends JpaRepository<Obj, Type>

### Exception
- @ResponseStatus(value = HttpStatus.NOT_FOUND)
