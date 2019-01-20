package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class AbstractStoreTest {

    private Store<Role> role;
    private Role comp = new Role("Computer and Information Systems Managers");
    private Role engineer = new Role("Engineering Managers.");
    private Role natural = new Role("Natural Sciences Managers");
    private Role life = new Role("Life Scientists");
    private Role account = new Role("Accountants and Auditors");

    @Before
    public void setUp() {
        role = new RoleStore<>();

        role.add(comp);
        role.add(engineer);
        role.add(natural);
        role.add(life);
        role.add(account);
    }

    @Test
    public void whenTryReplaceDeleteAndFindNotExistIdThenFalseOrNull() {
        assertThat(role.replace("77946186386", new Role("Nurses")), is(false));
        assertThat(role.delete("8792797995848769"), is(false));
        assertThat(role.findById("937506075026469"), is(nullValue()));
    }

    /**
     * Test of opportunity to raise the store
     */
    @Test
    public void whenAddExtraModelThenGetOne() {
        Role nurses = new Role("Nurses");
        role.add(nurses);

        Role result = role.findById(nurses.getId());

        assertThat(result.getRole(), is("Nurses"));
    }

    @Test
    public void whenReplaceEngineerModelAfterGetNursesAndTryFindEngineerThenGetNursesAndNull() {
        Role nurses = new Role("Nurses");

        role.replace(engineer.getId(), nurses);
        Role result = role.findById(nurses.getId());

        assertThat(result.getRole(), is("Nurses"));
        assertThat(role.findById(engineer.getId()), is(nullValue()));
    }

    @Test
    public void whenDeleteNaturalModelAndTryFindOneThenNull() {
        role.delete(natural.getId());

        assertThat(role.findById(natural.getId()), is(nullValue()));
    }
}