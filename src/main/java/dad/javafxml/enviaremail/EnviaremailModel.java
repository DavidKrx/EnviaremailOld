package dad.javafxml.enviaremail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EnviaremailModel {

		
			private Email email = new SimpleEmail();

			public Email getEmail() {
				return email;
			}

			public void setEmail(Email email) {
				this.email = email;
			}
			
			
		
}
