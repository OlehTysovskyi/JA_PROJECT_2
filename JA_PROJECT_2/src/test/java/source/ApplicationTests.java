package source;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import source.dao.EntrantRepository;
import source.dao.SpecialityRepository;
import source.dao.UserRepository;
import source.domain.Entrant;
import source.domain.Speciality;
import source.domain.User;
import source.domain.UserRole;
import source.service.EntrantService;
import source.service.SpecialityService;
import source.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
class ApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SpecialityService specialityService;

	@Autowired
	private SpecialityRepository specialityRepository;

	@Autowired
	private EntrantService entrantService;

	@Autowired
	private EntrantRepository entrantRepository;

	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(3));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(4));

		User userFromDb = users.get(39);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}

	@Test
	public void testFindByEmail() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(4));

		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(5));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}

	@Test
	public void testSaveFaculty() {
		List<Speciality> specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(0));

		Speciality speciality = new Speciality();
		speciality.setSpecialityName("1");
		speciality.setMinAvZno(1);
		specialityService.save(speciality);

		specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(1));

		Speciality specialityFromDb = specialities.get(0);
		assertTrue(specialityFromDb.getSpecialityName().equals(speciality.getSpecialityName()));
		assertTrue(specialityFromDb.getMinAvZno() == (speciality.getMinAvZno()));
	}

	@Test
	public void testFindById() {
		List<Speciality> specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(0));

		Speciality speciality = new Speciality();
		speciality.setSpecialityName("1");
		speciality.setMinAvZno(1);
		specialityService.save(speciality);

		specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(1));

		Speciality specialityFromDb = specialityService.findById(specialities.get(0).getSpecialityID()).get();

		assertTrue(specialityFromDb.getSpecialityName().equals(speciality.getSpecialityName()));
		assertTrue(specialityFromDb.getMinAvZno() == (speciality.getMinAvZno()));

	}

	@Test
	public void testGetAllFaculty() {
		List<Speciality> specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(0));

		Speciality speciality = new Speciality();
		speciality.setSpecialityName("1");
		speciality.setMinAvZno(1);
		specialityService.save(speciality);

		Speciality speciality2 = new Speciality();
		speciality.setSpecialityName("12");
		speciality.setMinAvZno(2);
		specialityService.save(speciality2);

		specialities = specialityRepository.findAll();
		assertThat(specialities, hasSize(2));

		List<Speciality> specialitiesFromDb = specialityService.getAllSpecialities();

		assertTrue(specialitiesFromDb.get(0).getSpecialityName().equals(speciality.getSpecialityName()));
		assertTrue(specialitiesFromDb.get(0).getMinAvZno() == (speciality.getMinAvZno()));

		assertTrue(specialitiesFromDb.get(1).getSpecialityName().equals(speciality2.getSpecialityName()));
		assertTrue(specialitiesFromDb.get(1).getMinAvZno() == (speciality2.getMinAvZno()));
	}

	@Test
	public void testSaveToBucket() {
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		User userFromDb = userRepository.findAll().stream().findFirst().get();

		List<Speciality> specialities = specialityRepository.findAll();

		Speciality speciality = new Speciality();
		speciality.setSpecialityName("1");
		speciality.setMinAvZno(1);
		specialityService.save(speciality);

		Speciality specialityFromDb = specialityRepository.findAll().stream().findFirst().get();
		assertThat(specialities, hasSize(0));

		Entrant entrant = new Entrant();

		entrant.setUser(userFromDb);
		entrant.setSpeciality(specialityFromDb);
		entrant.setAvZnoScore(1);

		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));

		entrantService.save(entrant);

		entrants = entrantRepository.findAll();

		assertThat(entrants, hasSize(1));

		Entrant entrantFromDb = entrants.get(0);

		assertTrue(entrantFromDb.getUser().equals(userFromDb));
		assertTrue(entrantFromDb.getSpeciality().equals(specialityFromDb));
		assertTrue(entrantFromDb.getAvZnoScore() == entrant.getAvZnoScore());

	}

	@Test
	public void testGetAllInfo() {
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		User userFromDb = userRepository.findAll().stream().findFirst().get();

		List<Speciality> specialities = specialityRepository.findAll();

		Speciality speciality = new Speciality();
		speciality.setSpecialityName("1");
		speciality.setMinAvZno(1);

		Speciality speciality2 = new Speciality();
		speciality2.setSpecialityName("2");
		speciality2.setMinAvZno(2);
		specialityRepository.saveAll(Arrays.asList(speciality, speciality2));
		List<Speciality> specialityFromDb = specialityRepository.findAll().stream().toList();

		Entrant entrant = new Entrant();
		assertThat(specialities, hasSize(0));

		entrant.setUser(userFromDb);
		entrant.setSpeciality(specialityFromDb.get(0));
		entrant.setAvZnoScore(1);

		Entrant entrant2 = new Entrant();

		entrant2.setUser(userFromDb);
		entrant2.setSpeciality(specialityFromDb.get(1));
		entrant2.setAvZnoScore(2);

		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));

		entrantRepository.saveAll(Arrays.asList(entrant, entrant2));

		List<Entrant> entrantFromDb = entrantService.getAllEntrants();

		assertThat(entrantFromDb, hasSize(2));
	}
}
