package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.testutil.DentistBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code SearchDentistCommand}.
 */
class SearchDentistCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    private NameContainsKeywordsPredicate preparePredicate(String searchString) {
        return new NameContainsKeywordsPredicate(Arrays.asList(searchString.split("\\s+")));
    }

    @Test
    public void execute_zeroKeywords_noDentistFound() {
        String expectedMessage = String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        expectedModel.updateFilteredDentistList(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(Collections.emptyList(), model.getFilteredDentistList());
    }

    @Test
    public void execute_multipleKeywords_multipleDentistsFound() {
        model.addDentist(new DentistBuilder().withName("May").build());
        model.addDentist(new DentistBuilder().withName("Tom").build());
        model.addDentist(new DentistBuilder().withName("Holland").build());

        String expectedMessage = String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate predicate = preparePredicate("Tom Holland May");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        expectedModel.updateFilteredDentistList(predicate);

        CommandResult commandResult = command.execute(model);
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(3, model.getFilteredDentistList().size());
    }

    @Test
    public void execute_noMatchingKeyword_noDentistFound() {
        NameContainsKeywordsPredicate predicate = preparePredicate("NonexistentKeyword");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 0), commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_similarButNoExactMatch_keywords() {
        NameContainsKeywordsPredicate predicate = preparePredicate("Jonn");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 0), commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_caseInsensitiveSearch_keywordFound() {
        model.addDentist(new DentistBuilder().withName("John").build());
        NameContainsKeywordsPredicate predicate = preparePredicate("john");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 1), commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_nonAlphanumericCharactersSearch_noDentistFound() {
        NameContainsKeywordsPredicate predicate = preparePredicate("@#$%");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 0), commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_mixtureOfValidAndInvalidKeywords() {
        NameContainsKeywordsPredicate predicate = preparePredicate("ValidName InvalidName");
        SearchDentistCommand command = new SearchDentistCommand(predicate);
        CommandResult commandResult = command.execute(model);
        assertEquals(String.format(Messages.MESSAGE_DENTISTS_LISTED_OVERVIEW, 0), commandResult.getFeedbackToUser());
    }
}