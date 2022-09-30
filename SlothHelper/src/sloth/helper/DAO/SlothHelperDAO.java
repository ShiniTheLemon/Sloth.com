package sloth.helper.DAO;
import sloth.helper.login.*;
import sloth.helper.user.signup.*;

import java.util.List;
import java.util.Map;

import sloth.helper.randomizer.*;
import sloth.create.deck.*;
import sloth.show.deck.*;

public interface SlothHelperDAO {

	SlothLogin SlothLogin(String user_name, String user_password);
	 boolean SlothSignUp(SlothSignUp SlothSignUp);
	 boolean SlothCreateDeck(CreateDeck CreateDeck);
	 List<ShowDeck> ShowDeck();
	 boolean DeleteWord(int deck_id);
	 boolean EditWord(ShowDeck EditDeck);
	 Randomizer Quiz();
	 Map<Randomizer,Randomizer>Quiz2();
	 Map<String,String>Quiz3();
	 Map<String,String>Quiz4();
}
