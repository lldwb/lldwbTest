package controller;

import edu.nf.bookcard.controller.BookcardInfoController;
import org.junit.jupiter.api.Test;

/**
 * @author 安然的尾巴
 * @version 1.0
 */
public class BookcardInfoControllerTest {
    @Test
    public void get(){
        BookcardInfoController controller = new BookcardInfoController();
        System.out.println(controller.get());
    }
}
