//package seedu.address.logic.commands;
//
//import org.junit.jupiter.api.Test;
//import seedu.address.logic.commands.tutorials.AddTutorialCommand;
//import seedu.address.model.event.tutorial.Tutorial;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static seedu.address.testutil.Assert.assertThrows;
//
//public class AddTutorialCommandTest {
//
//
//    @Test
//    public void constructor_nullTutorial_throwsNullPointerException() {
//        assertThrows(NullPointerException.class, () -> new AddTutorialCommand(null));
//    }
//
//
//    @Test
//    public void execute_tutorialAcceptedByModel_addSuccessful() throws Exception {
//        AddTutorialCommandTest.ModelStubAcceptingTutorialAdded modelStub
//                = new AddTutorialCommandTest.ModelStubAcceptingTutorialAdded();
//        Tutorial validTutorial = new TutorialBuilder().build();
//
//        CommandResult commandResult = new AddTutorialCommand(validTutorial).execute(modelStub);
//
//        assertEquals(String.format(AddTutorialCommand.MESSAGE_SUCCESS, validTutorial), commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validTutorial), modelStub.tutorialsAdded);
//    }
//}
